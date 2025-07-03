package com.tui.proof.ws.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tui.proof.mappers.OrderMapper;
import com.tui.proof.model.OrderUseCase;
import com.tui.proof.ws.controller.jto.Order;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OrdersController {

	private final OrderUseCase orderUseCase;

	@GetMapping("/test")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	void test() {
		// This is just a test endpoint to verify the controller is working
		log.info("Foo controller");
	}

	@GetMapping("/order")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public List<Order> findOrders() {
		return List.of();
	}

	@PostMapping("/order")
	public Long createOrder(@RequestBody Order order) {
		return orderUseCase.createOrder(OrderMapper.INSTANCE.fromJtoToModel(order));
	}

	@PutMapping("/order")
	public void updateOrder(@RequestBody Order order) {
		orderUseCase.updateOrder(OrderMapper.INSTANCE.fromJtoToModel(order));
	}

}
