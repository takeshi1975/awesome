package com.tui.proof.model;

import java.util.Objects;
import lombok.Data;

@Data
public class Client {
  private Long id;
  private String firstName;
  private String lastName;
  private String telephone;
  private String email;

  @Override
  public boolean equals(Object object) {
    if (object instanceof Client client) {
      return this.id.equals(client.getId());
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (Objects.isNull(id)) return 0;
    return this.id.hashCode();
  }
}
