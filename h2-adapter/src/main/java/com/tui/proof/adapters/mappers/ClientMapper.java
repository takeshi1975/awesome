package com.tui.proof.mappers;

import org.mapstruct.Mapper;

import com.tui.proof.model.Client;

@Mapper(componentModel = "spring")
public interface ClientMapper {
	com.tui.proof.adapters.model.Client toEntity(Client client);
	Client toModel(com.tui.proof.adapters.model.Client client);		
}
