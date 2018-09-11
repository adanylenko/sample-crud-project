package a.danylenko.sampleproject.rest;

import a.danylenko.sampleproject.dto.HealthResponse;
import a.danylenko.sampleproject.dto.ResponseWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

  @RequestMapping(value = "/health", method = RequestMethod.GET)
  public ResponseEntity<ResponseWrapper<HealthResponse>> index() {
    return ResponseWrapper.success(new HealthResponse());
  }
}
