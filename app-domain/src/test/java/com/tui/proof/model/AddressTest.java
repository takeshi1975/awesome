package com.tui.proof.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.datafaker.Faker;

public class AddressTest {

    private Faker faker;

    @BeforeEach
    void setUp() {
        faker = new Faker();
    }

    @Test
    void testAddressSettersAndGetters() {
        Address address = new Address();

        Long id = faker.number().randomNumber();
        String street = faker.address().streetAddress();
        String postcode = faker.address().zipCode();
        String city = faker.address().city();
        String country = faker.address().country();

        address.setId(id);
        address.setStreet(street);
        address.setPostcode(postcode);
        address.setCity(city);
        address.setCountry(country);

        assertEquals(id, address.getId());
        assertEquals(street, address.getStreet());
        assertEquals(postcode, address.getPostcode());
        assertEquals(city, address.getCity());
        assertEquals(country, address.getCountry());
    }

    @Test
    void testEqualsHashCodeAndToString() {
        Address a1 = new Address();
        a1.setId(1L);
        a1.setStreet("Calle A");
        a1.setPostcode("12345");
        a1.setCity("Madrid");
        a1.setCountry("España");

        // Igual a sí mismo
        assertEquals(a1, a1);

        // No igual a null
        assertNotEquals(a1, null);

        // No igual a otro tipo
        assertNotEquals(a1, "otro");

        // Igual a otro con mismos datos
        Address a2 = new Address();
        a2.setId(1L);
        a2.setStreet("Calle A");
        a2.setPostcode("12345");
        a2.setCity("Madrid");
        a2.setCountry("España");
        assertEquals(a1, a2);
        assertEquals(a1.hashCode(), a2.hashCode());

        // Diferente en un campo
        a2.setStreet("Calle B");
        assertNotEquals(a1, a2);

        // toString
        assertTrue(a1.toString().contains("Calle A"));
    }

    @Test
    void testToStringIsNotNull() {
        Address address = new Address();
        address.setId(2L);
        address.setStreet("Gran Via");
        address.setPostcode("08010");
        address.setCity("Madrid");
        address.setCountry("Spain");

        String toString = address.toString();
        assertNotNull(toString);
        assertTrue(toString.contains("Gran Via"));
    }
}
