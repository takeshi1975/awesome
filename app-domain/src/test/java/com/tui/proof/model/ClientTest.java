package com.tui.proof.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.datafaker.Faker;

public class ClientTest {

    private Faker faker;

    @BeforeEach
    void setUp() {
        faker = new Faker();
    }

    @Test
    void testClientSettersAndGetters() {
        Client client = new Client();

        Long id = faker.number().randomNumber();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String telephone = faker.phoneNumber().cellPhone();
        String email = faker.internet().emailAddress();

        client.setId(id);
        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setTelephone(telephone);
        client.setEmail(email);

        assertEquals(id, client.getId());
        assertEquals(firstName, client.getFirstName());
        assertEquals(lastName, client.getLastName());
        assertEquals(telephone, client.getTelephone());
        assertEquals(email, client.getEmail());
    }

    @Test
    void testEqualsHashCodeAndToString() {
        Client c1 = new Client();
        c1.setId(1L);
        c1.setFirstName("Ana");
        c1.setLastName("García");
        c1.setTelephone("600111222");
        c1.setEmail("ana@example.com");

        assertEquals(c1, c1);
        assertNotEquals(c1, null);
        assertNotEquals(c1, new Object());

        Client c2 = new Client();
        c2.setId(1L);
        c2.setFirstName("Ana");
        c2.setLastName("García");
        c2.setTelephone("600111222");
        c2.setEmail("ana@example.com");

        assertEquals(c1, c2);
        assertEquals(c1.hashCode(), c2.hashCode());

        c2.setEmail("otra@example.com");
        assertNotEquals(c1, c2);

        assertTrue(c1.toString().contains("Ana"));
    }
    @Test
    void testToStringIsNotNull() {
        Client client = new Client();
        client.setId(2L);
        client.setFirstName("Alice");
        client.setLastName("Smith");
        client.setTelephone("987654321");
        client.setEmail("alice.smith@example.com");

        String toString = client.toString();
        assertNotNull(toString);
        assertTrue(toString.contains("Alice"));
    }
}