package mypackage;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Does the person own a dog? (yes/no): ");
        boolean ownsDog = scanner.nextLine().trim().equalsIgnoreCase("yes");

        System.out.print("Enter the person's name: ");
        String personName = scanner.nextLine().trim();

        System.out.print("Enter the person's age: ");
        int personAge = Integer.parseInt(scanner.nextLine().trim());

        // Creating Person with or without Dog
        Person person = Optional.of(ownsDog)
                .map(yes -> yes ? createPersonWithDog(personName, personAge, scanner) : new Person(personName, personAge))
                .orElseThrow();

        // If person has no dog, printing message and exit
        Optional.ofNullable(person.getDog().orElse(null))
                .map(dog -> person)
                .orElseGet(() -> {
                    System.out.println("\nPerson Details:");
                    System.out.println("Name: " + personName);
                    System.out.println("Age: " + personAge);
                    System.out.println("This person does not own a dog.");
                    return null;
                });

        // Change Dog’s Name
        Optional.ofNullable(person.getDog().orElse(null))
                .ifPresent(dog -> {
                    // Print details before name change
                    System.out.println("\nBefore Name Change:");
                    printPersonDetails(person);

                    System.out.print("\nEnter new name for the dog: ");
                    String newDogName = scanner.nextLine().trim();

                    try {
                        person.changeDogsName(newDogName);
                        System.out.println("\nAfter Name Change:");
                        printPersonDetails(person);
                    } catch (RuntimeException e) {
                        System.out.println("Unable to change dog's name: " + e.getMessage());
                    }
                });

        scanner.close();
    }

    private static Person createPersonWithDog(String personName, int personAge, Scanner scanner) {
        System.out.print("Enter dog's name: ");
        String dogName = scanner.nextLine().trim();

        System.out.print("Enter dog's age: ");
        int dogAge = Integer.parseInt(scanner.nextLine().trim());

        return new Person(personName, personAge, new Dog(dogName, dogAge));
    }

    private static void printPersonDetails(Person person) {
        System.out.println("Person Name: " + person.getName());
        System.out.println("Person Age: " + person.getAge());
        person.getDog().ifPresent(dog -> {
            System.out.println("Dog Name: " + dog.getName());
            System.out.println("Dog Age: " + dog.getAge());
        });
    }
}
