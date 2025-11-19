package com.tui.proof.mappers;

import org.mapstruct.Mapper;

import com.tui.proof.model.Client;

@Mapper(componentModel = "spring")
public interface WebClientMapper {
	com.tui.proof.adapters.model.Client toEntity(Client client);

	Client toModel(com.tui.proof.adapters.model.Client client);

	com.tui.proof.ws.controller.jto.Client toJto(Client client);

}
