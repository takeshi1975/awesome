package com.tui.proof.adopters.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tui.proof.adapters.model.Client;
import com.tui.proof.adapters.model.Order;

@Mapper
public interface OrderRepository {
	public List<Order> findOrdersByClientCriteria(@Param("client") Client client);
	public Long createOrder(Order order);
	public int updateOrder(Order order);
	public String getNextOrderNumber();
}
