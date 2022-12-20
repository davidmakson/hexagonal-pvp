package inditex.price.adapter.in.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PvpNotFoundException extends RuntimeException {
  public PvpNotFoundException() {
    super();
  }
  public PvpNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }
  public PvpNotFoundException(String message) {
    super(message);
  }
  public PvpNotFoundException(Throwable cause) {
    super(cause);
  }
}
