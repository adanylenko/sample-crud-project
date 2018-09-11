package a.danylenko.sampleproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseWrapper<T> {

  private int code;
  private String message;
  private T data;

  public static <T> ResponseEntity<ResponseWrapper<T>> response(final T data, final String error,
      final HttpStatus httpStatus) {
    return new ResponseEntity<ResponseWrapper<T>>(
        new ResponseWrapper<T>(httpStatus.value(), error, data), new HttpHeaders(), httpStatus);
  }

  public static <T> ResponseEntity<ResponseWrapper<T>> success(final T data,
      final HttpStatus httpStatus) {
    return response(data, null, httpStatus);
  }

  public static <T> ResponseEntity<ResponseWrapper<T>> success(final T data) {
    return success(data, HttpStatus.OK);
  }

  public static <T> ResponseEntity<ResponseWrapper<T>> failure(final String error,
      final HttpStatus httpStatus) {
    return response(null, error, httpStatus);
  }

  public static <T> ResponseEntity<ResponseWrapper<T>> failure(final String error) {
    return failure(error, HttpStatus.BAD_REQUEST);
  }
}