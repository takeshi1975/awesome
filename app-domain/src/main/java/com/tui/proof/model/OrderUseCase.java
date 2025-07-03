package com.tui.proof.model;

import java.util.List;

public interface OrderUseCase {
	Long createOrder(Order order);

	List<Order> findOrdersByClient(Client client);

	void updateOrder(Order order);
	
	Long getNextOrderNumber();

}
