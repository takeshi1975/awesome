package com.tui.proof.ws.controller.jto;

import com.tui.proof.model.Client;
import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ClientTest {

  private final Faker faker = new Faker();
  private com.tui.proof.model.Client client;

  @BeforeEach
  void setUp() {
    client = new com.tui.proof.model.Client();
    client.setId(faker.number().randomNumber());
    client.setFirstName(faker.name().firstName());
    client.setLastName(faker.name().lastName());
    client.setTelephone(faker.phoneNumber().phoneNumber());
    client.setEmail(faker.internet().emailAddress());
  }

  @Test
  void testGettersAndSetters() {
    com.tui.proof.model.Client other = new com.tui.proof.model.Client();
    Long id = faker.number().randomNumber();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String phone = faker.phoneNumber().phoneNumber();
    String email = faker.internet().emailAddress();

    other.setId(id);
    other.setFirstName(firstName);
    other.setLastName(lastName);
    other.setTelephone(phone);
    other.setEmail(email);

    assertEquals(id, other.getId());
    assertEquals(firstName, other.getFirstName());
    assertEquals(lastName, other.getLastName());
    assertEquals(phone, other.getTelephone());
    assertEquals(email, other.getEmail());
  }

  @Test
  void testEqualsSameObject() {
    assertEquals(client, client); // misma referencia
  }

  @Test
  void testEqualsNull() {
    assertNotEquals(null, client);
  }

  @Test
  void testEqualsDifferentClass() {
    assertNotEquals("not a client", client);
  }

  @Test
  void testEqualsDifferentId() {
    com.tui.proof.model.Client other = new com.tui.proof.model.Client();
    other.setId(faker.number().randomNumber());
    assertNotEquals(client, other);
  }

  @Test
  void testEqualsSameId() {
    com.tui.proof.model.Client other = new com.tui.proof.model.Client();
    other.setId(client.getId());
    assertEquals(client, other);
  }

  @Test
  void testEqualsBothNullIds() {
    com.tui.proof.model.Client c1 = new com.tui.proof.model.Client();
    com.tui.proof.model.Client c2 = new com.tui.proof.model.Client();
    assertEquals(c1, c2);
  }

  @Test
  void testHashCodeWithId() {
    com.tui.proof.model.Client other = new com.tui.proof.model.Client();
    other.setId(client.getId());
    assertEquals(client.hashCode(), other.hashCode());
  }

  @Test
  void testHashCodeWithoutId() {
    com.tui.proof.model.Client c = new Client();
    assertNotEquals(0, c.hashCode());
  }
}
