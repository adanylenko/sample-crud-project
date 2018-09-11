package a.danylenko.sampleproject.exceptions;

public class NoSuchUserException extends Exception {
  public NoSuchUserException() {
    //default
  }

  public NoSuchUserException(final String message) {
    super(message);
  }
}
