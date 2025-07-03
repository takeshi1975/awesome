package com.tui.proof.model;

import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    private Faker faker;

    @BeforeEach
    void setUp() {
        faker = new Faker();
    }

    @Test
    void testOrderSettersAndGetters() {
        Order order = new Order();

        String number = faker.idNumber().valid();
        Client client = new Client();
        client.setId(1L);
        client.setFirstName("Test");
        client.setLastName("User");
        client.setTelephone("123456789");
        client.setEmail("test@example.com");

        Address address = new Address();
        address.setId(1L);
        address.setStreet("Test Street");
        address.setPostcode("12345");
        address.setCity("Test City");
        address.setCountry("Test Country");

        int pilotes = 3;
        double total = 29.99;
        LocalDateTime creation = LocalDateTime.now();

        order.setNumber(number);
        order.setClient(client);
        order.setDeliveryAddress(address);
        order.setPilotes(pilotes);
        order.setOrderTotal(total);
        order.setCreationDate(creation);

        assertEquals(number, order.getNumber());
        assertEquals(client, order.getClient());
        assertEquals(address, order.getDeliveryAddress());
        assertEquals(pilotes, order.getPilotes());
        assertEquals(total, order.getOrderTotal());
        assertEquals(creation, order.getCreationDate());
    }

    @Test
    void testEqualsHashCodeAndToString() {
        Client client = new Client();
        client.setId(1L);
        client.setFirstName("Juan");
        client.setLastName("López");
        client.setTelephone("600000000");
        client.setEmail("juan@example.com");

        Address address = new Address();
        address.setId(2L);
        address.setStreet("Gran Via");
        address.setPostcode("28001");
        address.setCity("Madrid");
        address.setCountry("España");

        LocalDateTime now = LocalDateTime.now();

        Order o1 = new Order();
        o1.setNumber("ORD123");
        o1.setClient(client);
        o1.setDeliveryAddress(address);
        o1.setPilotes(2);
        o1.setOrderTotal(29.95);
        o1.setCreationDate(now);

        assertEquals(o1, o1);
        assertNotEquals(o1, null);
        assertNotEquals(o1, new Object());

        Order o2 = new Order();
        o2.setNumber("ORD123");
        o2.setClient(client);
        o2.setDeliveryAddress(address);
        o2.setPilotes(2);
        o2.setOrderTotal(29.95);
        o2.setCreationDate(now);

        assertEquals(o1, o2);
        assertEquals(o1.hashCode(), o2.hashCode());

        o2.setOrderTotal(99.99);
        assertNotEquals(o1, o2);

        assertTrue(o1.toString().contains("ORD123"));
    }

    @Test
    void testToStringIsNotNull() {
        Order order = new Order();
        order.setNumber("ORD-999");
        order.setClient(new Client());
        order.setDeliveryAddress(new Address());
        order.setPilotes(1);
        order.setOrderTotal(9.99);
        order.setCreationDate(LocalDateTime.now());

        String toString = order.toString();
        assertNotNull(toString);
        assertTrue(toString.contains("ORD-999"));
    }
}
