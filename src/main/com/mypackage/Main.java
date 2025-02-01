package mypackage;

public class Main {
    public static void main(String[] args) {
        // Creating three Dog objects with predefined names and ages
        Dog dog1 = new Dog("Simba", 8);
        Dog dog2 = new Dog("Snoppy", 5);
        Dog dog3 = new Dog("Goofy", 10);

        // Creating Person objects and assigning dogs to them
        Person person1 = new Person("Eshwar", 24, dog1);
        Person person2 = new Person("Rudraksh", 27, dog2);
        Person person3 = new Person("Keerthi", 23, dog3);

        // Output for each person before and after changing the dog's name
        changeDogNameForPerson(person1, "Mufasa");
        changeDogNameForPerson(person2, "Nala");
        changeDogNameForPerson(person3, "Scar");

        // Trying with person without a dog (person who does not own a dog)
        Person personWithoutDog = new Person("Evil", 29);
        personWithoutDog.changeDogsName("Charlie");
    }

    private static void changeDogNameForPerson(Person person, String newName) {
        // Using Optional's ifPresent method to check and change the dog's name
        person.getDog().ifPresent(dog -> {
            System.out.println("Before change: " + person.getName() + ", " + person.getAge() + ", Dog's name: " + dog.getName() + ", Dog's age: " + dog.getAge());
            person.changeDogsName(newName);
            System.out.println("After change: " + person.getName() + ", " + person.getAge() + ", Dog's name: " + dog.getName() + ", Dog's age: " + dog.getAge());
        });

        person.getDog().orElseThrow(() -> new RuntimeException(person.getName() + " does not own a dog!"));
    }
}
