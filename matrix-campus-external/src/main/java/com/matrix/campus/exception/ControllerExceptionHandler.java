package com.matrix.campus.exception;

import static com.matrix.campus.application.ApplicationValues.BAD_REQUEST_FIELD_SEPARATOR;

import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Log4j2
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

  @Override
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                             HttpStatusCode status, WebRequest request) {

    List<String> errors = ex.getBindingResult().getFieldErrors()
        .stream()
        .map(error -> String.join(BAD_REQUEST_FIELD_SEPARATOR, error.getField(), error.getDefaultMessage()))
        .toList();
    return ResponseEntity.status(HttpStatus.CONFLICT).body(errors);
  }

  @ExceptionHandler(TooManyDataException.class)
  public ResponseEntity<String> handleTooManyDataException(TooManyDataException e) {
    return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
  }

  @ExceptionHandler(UnexpectedErrorException.class)
  public ResponseEntity<String> handleUnexpectedErrorException(UnexpectedErrorException e) {
    log.error(e.getMessageCause());
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
  }

  @ExceptionHandler(NoDataException.class)
  public ResponseEntity<String> handleNoContent(NoDataException e) {
    return ResponseEntity.status(HttpStatus.NO_CONTENT).body((e.getMessage()));
  }
}
