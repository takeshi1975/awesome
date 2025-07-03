package com.tui.proof.ws.controller.jto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
	@Size(max = 20, message = "telephone should not be longer than 20 characters")
	private String telephone;
	@NotBlank(message = "email could not be null")
	@Size(max = 100, message = "email should not be longer than 100 characters")
	@Pattern(
			regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$",
			message = "email is not valid")
	private String email;
}
