package com.tui.proof.model;

import lombok.Data;

@Data
public class Address {
  private Long id;
  private String street;
  private String postcode;
  private String city;
  private String country;
}
