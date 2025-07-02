package com.tui.proof.model;

import java.util.List;

public interface H2Port {
	int createOrder(Order order);

	Order updateOrder(Order order);

	List<Order> findByClient(Client client);
}
