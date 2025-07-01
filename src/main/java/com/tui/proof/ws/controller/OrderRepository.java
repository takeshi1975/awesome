package com.tui.proof.ws.controller;

import com.tui.proof.adapters.model.Client;
import com.tui.proof.adapters.model.Order;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface OrderRepository {

	@Select("SELECT * FROM Orders")
	public List<Order> findOrderByClient(Client client);

	@Insert("INSERT INTO Orders(number, address_id, pilotes, order_total, creation_date) " +
		"VALUES (#{number}, #{addressId}, #{pilotes}, #{orderTotal}, #{creationDate})")
	public int createOrder(Order order);

	@Update("UPDATE Orders set address_id=#{addresId}, pilotes=#{pilotes}, order_total=#{orderTotal}" +
		" WHERE number=#{number}")
	public int update(Order order);
}
