package com.tui.proof.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.tui.proof.model.Order;

@Mapper(componentModel = "spring", uses = { ClientMapper.class, AddressMapper.class })
public interface OrderMapper {
	OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
	
	Order toModel(com.tui.proof.adapters.model.Order order);
	
	com.tui.proof.adapters.model.Order toEntity(Order orderEntity);

}
