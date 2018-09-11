package a.danylenko.sampleproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HealthResponse {

  @Getter
  @Setter
  private boolean ok = true;
}