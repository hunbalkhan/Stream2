package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!\n");
        Scanner scanner = new Scanner(System.in);

        // 1. List of 10 ppl
        List<Person> people = new ArrayList<>();
        people.add(new Person("Olivia", "Martin", 28));
        people.add(new Person("Liam", "Johnson", 34));
        people.add(new Person("Sophia", "Brown", 22));
        people.add(new Person("Noah", "Davis", 40));
        people.add(new Person("Ava", "Miller", 19));
        people.add(new Person("Ethan", "Wilson", 27));
        people.add(new Person("Isabella", "Moore", 31));
        people.add(new Person("Mason", "Taylor", 45));
        people.add(new Person("Mia", "Anderson", 24));
        people.add(new Person("Lucas", "Thomas", 38));
        people.add(new Person("Ethan", "Margaret", 29));

        // 2. Prompt for a name (first/last)
        System.out.println("Enter a name to search (first or last)");
        String searchName = scanner.nextLine().trim();

        // empty list to put the matches users inside
        List<Person> matches = new ArrayList<>();

        for(Person person : people) {
            if (person.getFirstName().equalsIgnoreCase(searchName)
                    || person.getLastName().equalsIgnoreCase(searchName)) {
                matches.add(person);
            }
        }

        if (matches.isEmpty()) {
            System.out.println("No people found with that name...");
        }
        else {
            System.out.println("People found: ");
            for (Person match : matches) {
                System.out.println(match);
            }
        }

        // 3. Calculating average age, oldest, youngest.
        int totalAge = 0;
        int oldest = people.get(0).getAge();
        int youngest = people.get(0).getAge();

        // Loop through the ALL list and calculate total
        for(Person person : people) {
            // Add this person's age to the total
            totalAge += person.getAge();

            // If the person is older than the current one, update oldest
            if (person.getAge() > oldest) {
                oldest = person.getAge();
            }

            // If the person is younger than current, update youngest.
            if (person.getAge() < youngest) {
                youngest = person.getAge();
            }
        }

        // Calculate average by dividing total by amount of people
        double averageAge = (double) totalAge / people.size();

        // Displaying the average age, oldest, youngest.
        System.out.printf("Average age: %.2f \n", averageAge);
        System.out.println("Oldest age: " + oldest);
        System.out.println("Youngest age: " + youngest);
    }
}