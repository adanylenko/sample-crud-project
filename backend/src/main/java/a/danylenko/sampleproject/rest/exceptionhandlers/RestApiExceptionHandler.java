package a.danylenko.sampleproject.rest.exceptionhandlers;

import a.danylenko.sampleproject.dto.ResponseWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestApiExceptionHandler {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<?> handleException(final Exception exception) {
    return ResponseWrapper.failure(exception.getMessage(), HttpStatus.BAD_REQUEST);
  }
}