package com.tui.proof.ws.controller.jto;

import java.time.LocalDateTime;
import com.tui.proof.model.Address;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Order {
	private String number;
	@NotNull(message = "client could not be null")
	private Client client;
	@NotNull(message = "address could not be null")
	private Address deliveryAddress;
	@NotNull(message = "pilotes could not be null")
	private int pilotes;
	private double orderTotal;
	private LocalDateTime creationDate;
}
