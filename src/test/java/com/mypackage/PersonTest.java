package mypackage;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testPersonWithDog() {
        // Creating Dog and Person instances
        Dog dog = new Dog("Simba", 8);
        Person person = new Person("Eshwar", 24, dog);

        // Asserting that the person has the correct name
        assertEquals("Eshwar", person.getName());

        // Asserting that the person has the correct dog
        assertEquals("Simba", person.getDog().get().getName());
        assertEquals(8, person.getDog().get().getAge());
    }

    @Test
    void testPersonWithoutDog() {
        // Creating a person with no dog
        Person person = new Person("Evil", 29);

        // Asserting that the person has no dog (Optional should be empty)
        assertFalse(person.getDog().isPresent());
    }

    @Test
    void testChangeDogsName() {
        // Creating a dog and person with the dog
        Dog dog = new Dog("Simba", 8);
        Person person = new Person("Eshwar", 24, dog);

        // Before changing the dog's name
        assertEquals("Simba", person.getDog().get().getName());

        // Change the dog's name
        person.changeDogsName("Mufasa");

        // Asserting that the dog's name has been changed correctly
        assertEquals("Mufasa", person.getDog().get().getName());
    }

    @Test
    void testChangeDogsNameWithoutDog() {
        // Creating a person without a dog
        Person person = new Person("Evil", 29);

        // Trying to change the dog's name when the person does not own a dog
        Exception exception = assertThrows(RuntimeException.class, () -> {
            person.changeDogsName("Charlie");
        });

        // Asserting the exception message
        assertEquals("Evil does not own a dog!", exception.getMessage());
    }

    @Test
    void testHasOldDog() {
        // Creating a person with a dog that is older than 10
        Dog dog = new Dog("Goofy", 10);
        Person person = new Person("Keerthi", 23, dog);

        // Asserting that the person has an old dog (age >= 10)
        assertTrue(person.hasOldDog());

        // Creating a person with a dog younger than 10
        dog = new Dog("Snoppy", 5);
        person = new Person("Rudraksh", 27, dog);

        // Asserting that the person does not have an old dog (age < 10)
        assertFalse(person.hasOldDog());
    }
}
