package com.tui.proof.adapters;

import com.tui.proof.mappers.OrderMapper;
import com.tui.proof.ws.controller.OrderRepository;
import java.util.List;

import java.util.Objects;
import org.springframework.stereotype.Component;

import com.tui.proof.model.Client;
import com.tui.proof.model.Order;
import com.tui.proof.model.H2Port;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class H2Adapter implements H2Port {
	private final OrderMapper orderMapper;
	private final OrderRepository h2Repository;

	@Override
	public int createOrder(Order order) {
		if (Objects.isNull(order) || Objects.nonNull(order.getNumber())) {
			throw new IllegalArgumentException();
		}
		int newOrder = h2Repository.createOrder(orderMapper.toEntity(order));
		log.info("New orderId created {}", newOrder);
		return newOrder;
	}

	@Override
	public Order updateOrder(Order order) {
		h2Repository.update(orderMapper.toEntity(order));
		return order;
	}

	@Override
	public List<Order> findByClient(Client client) {
		return List.of();
	}
}
