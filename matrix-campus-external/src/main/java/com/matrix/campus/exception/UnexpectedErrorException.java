package com.matrix.campus.exception;

import lombok.Getter;

@Getter
public class UnexpectedErrorException extends RuntimeException {
  private final String messageCause;

  public UnexpectedErrorException(String message, String messageCause) {
    super(message);
    this.messageCause = messageCause;
  }
}
