package mypackage;

public class Dog {
    private String name;
    private Integer age;

    // Constructor to initialize dog with name and age
    public Dog(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    // Getter for the dog's name
    public String getName() {
        return name;
    }

    // Setter for the dog's name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for the dog's age
    public Integer getAge() {
        return age;
    }

    // Setter for the dog's age
    public void setAge(Integer age) {
        this.age = age;
    }

    // Overriding equals method to compare two dogs based on their name and age
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Dog dog = (Dog) obj;
        return name.equals(dog.name) && age.equals(dog.age);
    }

    // Overriding toString method to represent the dog as a string
    @Override
    public String toString() {
        return "Dog{name='" + name + "', age=" + age + "}";
    }
}