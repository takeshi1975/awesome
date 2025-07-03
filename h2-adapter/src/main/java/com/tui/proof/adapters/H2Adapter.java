package com.tui.proof.adapters;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.tui.proof.mappers.ClientMapper;
import com.tui.proof.mappers.OrderMapper;
import com.tui.proof.model.Client;
import com.tui.proof.model.H2Port;
import com.tui.proof.model.Order;
import com.tui.proof.adopters.repository.OrderRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class H2Adapter implements H2Port {
	
	private final OrderMapper orderMapper;
	private final ClientMapper clientMapper;
	private final OrderRepository h2Repository;

	@Override
	public Long createOrder(Order order) {
		if (Objects.isNull(order)) {
			throw new IllegalArgumentException();
		}
		Long newOrder = h2Repository.createOrder(orderMapper.toEntity(order));
		
		log.info("New orderId created {}", newOrder);
		return newOrder;
	}

	@Override
	public Order updateOrder(Order order) {
		h2Repository.updateOrder(orderMapper.toEntity(order));
		return order;
	}

	@Override
	public List<Order> findByClient(Client client) {
		return h2Repository.findOrdersByClientCriteria(clientMapper.toEntity(client))
				.stream()
				.map(orderMapper::toModel)
				.toList();
	}

	@Override
	public Long getNextOrderNumber() {
		String code = h2Repository.getNextOrderNumber();
		if (code==null || code.isBlank()) {
			return 1L;
		}
		return Long.valueOf(code)+1;
	}
	
}
