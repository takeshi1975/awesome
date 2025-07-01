package com.tui.proof.ws.controller;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.tui.proof.model.Client;
import com.tui.proof.model.Order;
import com.tui.proof.model.OrderUseCase;
import com.tui.proof.ports.H2Port;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrdersService implements OrderUseCase {

	private final H2Port h2Port;

	@Value("${com.tui.proof.maxUpdateTime}")
	private int maxMinutes;

	@Value("${com.tui.proof.price}")
	private Double price;

	private List<Integer> validQuantity = List.of(5, 10, 15);

	public int createOrder(Order order) {
		order.setCreationDate(LocalDateTime.now());
		order.setOrderTotal(order.getPilotes() * price);

		validQuantity.stream().filter(p -> p == order.getPilotes()).
			findFirst().orElseThrow(IllegalStateException::new);
		return h2Port.createOrder(order);
	}

	public void updateOrder(Order order) {
		final LocalDateTime now = LocalDateTime.now();
		final Duration difference = Duration.between(now, order.getCreationDate());
		if (difference.toMinutes() >= maxMinutes) {
			throw new IllegalStateException(); // the order is in progress.
		}
		h2Port.updateOrder(order);
	}

	public List<Order> findOrdersByClient(Client client) {
		return h2Port.findByClient(client).stream().toList();
	}
}
