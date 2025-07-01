package com.tui.proof.model;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Order {
	private String number;
	private Address deliveryAddress;
	private int pilotes;
	private double orderTotal;
	private LocalDateTime creationDate;
}
