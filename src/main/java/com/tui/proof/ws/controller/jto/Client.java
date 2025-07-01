package com.tui.proof.ws.controller.jto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Client {
	@NotNull(message = "please, provide a customer's Id")
	private Long id;
	@NotBlank(message = "first name could not be null")
	private String firstName;
	@NotBlank(message = "second name could not be null")
	private String lastName;
	@NotBlank(message = "telephone could not be null")
	private String telephone;
}
