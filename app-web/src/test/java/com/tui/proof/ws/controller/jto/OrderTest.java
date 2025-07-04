package com.tui.proof.ws.controller.jto;

import com.tui.proof.model.Address;
import com.tui.proof.model.Client;
import com.tui.proof.model.Order;
import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class OrderTest {

    private final Faker faker = new Faker();
    private com.tui.proof.model.Order order;

    @BeforeEach
    void setUp() {
        order = new com.tui.proof.model.Order();
        order.setNumber(faker.idNumber().valid());
        
        com.tui.proof.model.Client client = new com.tui.proof.model.Client();
        client.setId(faker.number().randomNumber());
        client.setFirstName(faker.name().firstName());
        client.setLastName(faker.name().lastName());
        client.setTelephone(faker.phoneNumber().phoneNumber());
        client.setEmail(faker.internet().emailAddress());
        order.setClient(client);

        com.tui.proof.model.Address address = new com.tui.proof.model.Address();
        address.setId(faker.number().randomNumber());
        address.setStreet(faker.address().streetAddress());
        address.setPostcode(faker.address().zipCode());
        address.setCity(faker.address().city());
        address.setCountry(faker.address().country());
        order.setDeliveryAddress(address);

        order.setPilotes(faker.number().numberBetween(1, 100));
        order.setOrderTotal(faker.number().randomDouble(2, 10, 1000));
        order.setCreationDate(LocalDateTime.now());
    }

    @Test
    void testGettersAndSetters() {
        com.tui.proof.model.Order other = new com.tui.proof.model.Order();
        String number = faker.idNumber().valid();
        int pilotes = faker.number().numberBetween(1, 50);
        Double total = faker.number().randomDouble(2, 100, 5000);
        LocalDateTime creationDate = LocalDateTime.now();

        com.tui.proof.model.Client client = new Client();
        client.setId(faker.number().randomNumber());
        client.setFirstName(faker.name().firstName());
        client.setLastName(faker.name().lastName());
        client.setTelephone(faker.phoneNumber().phoneNumber());
        client.setEmail(faker.internet().emailAddress());

        com.tui.proof.model.Address address = new Address();
        address.setId(faker.number().randomNumber());
        address.setStreet(faker.address().streetAddress());
        address.setPostcode(faker.address().zipCode());
        address.setCity(faker.address().city());
        address.setCountry(faker.address().country());

        other.setNumber(number);
        other.setClient(client);
        other.setDeliveryAddress(address);
        other.setPilotes(pilotes);
        other.setOrderTotal(total);
        other.setCreationDate(creationDate);

        assertEquals(number, other.getNumber());
        assertEquals(client, other.getClient());
        assertEquals(address, other.getDeliveryAddress());
        assertEquals(pilotes, other.getPilotes());
        assertEquals(total, other.getOrderTotal());
        assertEquals(creationDate, other.getCreationDate());
    }

    @Test
    void testEqualsSameObject() {
        assertEquals(order, order);
    }

    @Test
    void testEqualsNull() {
        assertNotEquals(order, null);
    }

    @Test
    void testEqualsDifferentClass() {
        assertNotEquals(order, "not an order");
    }

    @Test
    void testEqualsDifferentNumber() {
        com.tui.proof.model.Order other = new com.tui.proof.model.Order();
        other.setNumber(faker.idNumber().valid());
        assertNotEquals(order, other);
    }

    @Test
    void testEqualsSameNumber() {
        com.tui.proof.model.Order other = new com.tui.proof.model.Order();
        other.setNumber(order.getNumber());
        assertEquals(order, other);
    }

    @Test
    void testEqualsBothNullNumbers() {
        com.tui.proof.model.Order o1 = new com.tui.proof.model.Order();
        com.tui.proof.model.Order o2 = new com.tui.proof.model.Order();
        assertEquals(o1, o2);
    }

    @Test
    void testHashCodeWithNumber() {
        com.tui.proof.model.Order other = new com.tui.proof.model.Order();
        other.setNumber(order.getNumber());
        assertEquals(order.hashCode(), other.hashCode());
    }

    @Test
    void testHashCodeWithoutNumber() {
        com.tui.proof.model.Order o = new Order();
        assertEquals(0, o.hashCode());
    }
}
