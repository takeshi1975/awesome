package com.tui.proof.mappers;

import com.tui.proof.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderMapper {
	OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

	Order toModel(com.tui.proof.adapters.model.Order order);

	com.tui.proof.adapters.model.Order toEntity(Order orderEntity);

	com.tui.proof.ws.controller.jto.Order toJto(Order order);

	Order fromJtoToModel(com.tui.proof.ws.controller.jto.Order order);
}
