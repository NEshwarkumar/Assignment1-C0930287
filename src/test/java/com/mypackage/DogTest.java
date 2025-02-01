package mypackage;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DogTest {

    @Test
    void testDogNameAndAge() {
        // Creating a Dog instance with name and age
        Dog dog = new Dog("Simba", 8);

        // Asserting that the dog's name is correctly set
        assertEquals("Simba", dog.getName());

        // Asserting that the dog's age is correctly set
        assertEquals(8, dog.getAge());
    }

    @Test
    void testDogNameChange() {
        // Creating a Dog instance with name and age
        Dog dog = new Dog("Simba", 8);

        // Change the dog's name
        dog.setName("Mufasa");

        // Asserting that the dog's name has been changed correctly
        assertEquals("Mufasa", dog.getName());
    }
}
