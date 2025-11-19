package com.tui.proof.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.tui.proof.model.Order;

@Mapper(
    componentModel = "spring",
    uses = {WebClientMapper.class, WebAddressMapper.class})
public interface WebOrderMapper {
  com.tui.proof.mappers.WebOrderMapper INSTANCE = Mappers.getMapper(WebOrderMapper.class);

  Order toModel(com.tui.proof.adapters.model.Order order);

  com.tui.proof.adapters.model.Order toEntity(Order orderEntity);

  com.tui.proof.ws.controller.jto.Order toJto(Order order);

  Order fromJtoToModel(com.tui.proof.ws.controller.jto.Order order);
}
