package a.danylenko.sampleproject.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String firstName;
  private String lastName;

  @Override
  public String toString() {
    return String.format("Customer[id=%d, firstName='%s', lastName='%s']", id, firstName, lastName);
  }
}
