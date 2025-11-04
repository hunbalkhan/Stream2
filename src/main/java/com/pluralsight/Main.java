package com.pluralsight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!\n");
        Scanner scanner = new Scanner(System.in);

        // 1. List of 10 ppl
        List<Person> people = Arrays.asList(
        new Person("Olivia", "Martin", 28),
        new Person("Liam", "Johnson", 34),
        new Person("Sophia", "Brown", 22),
        new Person("Noah", "Davis", 40),
        new Person("Ava", "Miller", 19),
        new Person("Ethan", "Wilson", 27),
        new Person("Isabella", "Moore", 31),
        new Person("Mason", "Taylor", 45),
        new Person("Mia", "Anderson", 24),
        new Person("Lucas", "Thomas", 38),
        new Person("Ethan", "Margaret", 29)
        );

        // 2. Prompt for a name (first/last)
        System.out.println("Enter a name to search (first or last)");
        String searchName = scanner.nextLine().trim();

        // Search using Stream instead of loops.
        List<Person> matches = people.stream()
                .filter(p -> p.getFirstName().equalsIgnoreCase(searchName)
                ||
                p.getLastName().equalsIgnoreCase(searchName))
                .toList();

//        for(Person person : people) {
//            if (person.getFirstName().equalsIgnoreCase(searchName)
//                    || person.getLastName().equalsIgnoreCase(searchName)) {
//                matches.add(person);
//            }
//        }

        if (matches.isEmpty()) {
            System.out.println("No people found with that name...");
        }
        else {
            System.out.println("People found: ");
//            for (Person match : matches) {
//                System.out.println(match);
//            }

            matches.forEach(System.out::println);
        }

        // 3. Calculating average age, oldest, youngest.
//        int totalAge = 0;
//        int oldest = people.get(0).getAge();
//        int youngest = people.get(0).getAge();

        double averageAge = people.stream()
                .map(Person::getAge)
                .reduce(0, Integer::sum)
                / (double) people.size();

        // Oldest age (maximum)
        int oldest = people.stream()
                .map(Person::getAge)           // Converts each Person in the list to just their age (so you get a Stream<Integer>).
                .max(Integer::compareTo)       // Finds the largest value using the natural comparison of integers.
                .orElse(0);                    // default value if list is empty

        // Youngest age (minimum)
        int youngest = people.stream()
                .map(Person::getAge)
                .min(Integer::compareTo)
                .orElse(0);                    // default value if list is empty


        // Loop through the ALL list and calculate total
//        for(Person person : people) {
//            // Add this person's age to the total
//            totalAge += person.getAge();
//
//            // If the person is older than the current one, update oldest
//            if (person.getAge() > oldest) {
//                oldest = person.getAge();
//            }
//
//            // If the person is younger than current, update youngest.
//            if (person.getAge() < youngest) {
//                youngest = person.getAge();
//            }
//        }

        // Calculate average by dividing total by amount of people
        //double averageAge = (double) totalAge / people.size();

        // Displaying the average age, oldest, youngest.
        System.out.printf("\nAverage age: %.2f \n", averageAge);
        System.out.println("Oldest age: " + oldest);
        System.out.println("Youngest age: " + youngest);
    }
}