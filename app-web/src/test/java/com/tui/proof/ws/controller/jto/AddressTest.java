package com.tui.proof.ws.controller.jto;

import com.tui.proof.model.Address;
import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class AddressTest {

    private final Faker faker = new Faker();
    private com.tui.proof.model.Address address;

    @BeforeEach
    void setUp() {
        address = new com.tui.proof.model.Address();
        address.setId(faker.number().randomNumber());
        address.setStreet(faker.address().streetAddress());
        address.setPostcode(faker.address().zipCode());
        address.setCity(faker.address().city());
        address.setCountry(faker.address().country());
    }

    @Test
    void testGettersAndSetters() {
        com.tui.proof.model.Address other = new com.tui.proof.model.Address();
        Long id = faker.number().randomNumber();
        String street = faker.address().streetAddress();
        String postcode = faker.address().zipCode();
        String city = faker.address().city();
        String country = faker.address().country();

        other.setId(id);
        other.setStreet(street);
        other.setPostcode(postcode);
        other.setCity(city);
        other.setCountry(country);

        assertEquals(id, other.getId());
        assertEquals(street, other.getStreet());
        assertEquals(postcode, other.getPostcode());
        assertEquals(city, other.getCity());
        assertEquals(country, other.getCountry());
    }

    @Test
    void testEqualsSameObject() {
        assertEquals(address, address);
    }

    @Test
    void testEqualsNull() {
        assertNotEquals(address, null);
    }

    @Test
    void testEqualsDifferentClass() {
        assertNotEquals(address, "not an address");
    }

    @Test
    void testEqualsDifferentId() {
        com.tui.proof.model.Address other = new com.tui.proof.model.Address();
        other.setId(faker.number().randomNumber());
        assertNotEquals(address, other);
    }

    @Test
    void testEqualsSameId() {
        com.tui.proof.model.Address other = new com.tui.proof.model.Address();
        other.setId(address.getId());
        assertEquals(address, other);
    }

    @Test
    void testEqualsBothNullIds() {
        com.tui.proof.model.Address a1 = new com.tui.proof.model.Address();
        com.tui.proof.model.Address a2 = new com.tui.proof.model.Address();
        assertEquals(a1, a2);
    }

    @Test
    void testHashCodeWithId() {
        com.tui.proof.model.Address other = new com.tui.proof.model.Address();
        other.setId(address.getId());
        assertEquals(address.hashCode(), other.hashCode());
    }

    @Test
    void testHashCodeWithoutId() {
        com.tui.proof.model.Address a = new Address();
        assertEquals(0, a.hashCode());
    }
}
