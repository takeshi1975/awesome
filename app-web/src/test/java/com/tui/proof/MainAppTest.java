package com.tui.proof;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tui.proof.model.Address;
import com.tui.proof.model.Client;
import com.tui.proof.model.Order;
import com.tui.proof.model.OrderUseCase;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class MainAppTest {
	
	@Autowired
	private OrderUseCase ordersService;
	
	@Test
	public void test() {
		Order order = new Order();
		order.setNumber(null);
		order.setCreationDate(LocalDateTime.now());
		order.setPilotes(15);
		Address address = new Address();
		address.setId(1L);
		address.setCity("Madrid");
		address.setCountry("Spain");
		address.setStreet("Calle Mayor");
		address.setPostcode("28001");
		order.setDeliveryAddress(address);
		Client client = new Client();
		client.setId(1L);
		client.setFirstName("John");
		client.setLastName("Doe");
		client.setEmail("jhon.dome@gmail.com");
		client.setTelephone("123456789");
		order.setClient(client);
		order.setNumber(null);
		ordersService.createOrder(order);	
		order.setPilotes(10);
		ordersService.updateOrder(order);
		log.info("Order created and updated successfully");
		ordersService.findOrdersByClient(client).stream().forEach(o -> log.info("Order found: {}", o));
	}

}
