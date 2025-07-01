package com.tui.proof.ports;

import com.tui.proof.model.Client;
import com.tui.proof.model.Order;
import java.util.List;

public interface H2Port {
	int createOrder(Order order);

	Order updateOrder(Order order);

	List<Order> findByClient(Client client);
}
