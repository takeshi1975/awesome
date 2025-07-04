package com.tui.proof.mappers;

import org.mapstruct.Mapper;

import com.tui.proof.model.Address;

@Mapper(componentModel = "spring")
public interface AddressMapper {
	com.tui.proof.adapters.model.Address toEntity(Address address);
	Address toModel(com.tui.proof.adapters.model.Address address);	
}
