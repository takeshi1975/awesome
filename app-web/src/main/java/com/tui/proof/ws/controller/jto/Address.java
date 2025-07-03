package com.tui.proof.ws.controller.jto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class Address {
	@NotBlank(message = "street could not be null")
	private String street;
	@NotBlank(message = "postcode could not be null")
	@Pattern(regexp = "^\\d{5}$")
	private String postcode;
	@NotBlank(message = "city could not be null")
	private String city;
	@NotBlank(message = "country could not be null")
	private String country;
}
