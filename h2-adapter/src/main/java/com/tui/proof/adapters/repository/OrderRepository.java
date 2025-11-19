package com.tui.proof.adapters.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tui.proof.adapters.model.Client;
import com.tui.proof.adapters.model.Order;

public interface OrderRepository {
  public List<Order> findOrdersByClientCriteria(@Param("client") Client client);

  public Long createOrder(Order order);

  public int updateOrder(Order order);

  public String getNextOrderNumber();

  public List<Order> findAll();
}
