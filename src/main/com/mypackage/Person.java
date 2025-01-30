package mypackage;

import java.util.Optional;

public class Person {
    private String name;
    private Integer age;
    private Optional<Dog> dog;

    // Constructor for person without a dog
    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
        this.dog = Optional.empty();
    }

    // Constructor for person with a dog
    public Person(String name, Integer age, Dog dog) {
        this.name = name;
        this.age = age;
        this.dog = Optional.of(dog);
    }

    // Method to check if the person has an old dog (age >= 10)
    public boolean hasOldDog() {
        return dog.map(d -> d.getAge() >= 10).orElse(false);
    }

    // Method to change the dog's name, throws exception if the person has no dog
    public void changeDogsName(String newName) {
        dog.ifPresentOrElse(
                d -> d.setName(newName),
                () -> { throw new RuntimeException(this.name + " does not own a dog!"); }
        );
    }

    // Getters for name, age, and dog
    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Optional<Dog> getDog() {
        return dog;
    }

    // Overriding equals method to compare two persons based on name and age
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return name.equals(person.name) && age.equals(person.age);
    }

    // Overriding toString method to represent the person as a string
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", dog=" + dog.map(Dog::getName).orElse("None") + "}";
    }
}