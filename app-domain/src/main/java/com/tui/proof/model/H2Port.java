package com.tui.proof.model;

import java.util.List;

public interface H2Port {
  Long createOrder(Order order);

  Order updateOrder(Order order);

  List<Order> findByClient(Client client);

  Long getNextOrderNumber();

  List<Order> findAll();
}
