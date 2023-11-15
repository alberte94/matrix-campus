package com.matrix.campus.application;

import static lombok.AccessLevel.PRIVATE;

import lombok.NoArgsConstructor;

@NoArgsConstructor(access = PRIVATE)
public class ControllerMessages {
  public static final String ERROR_TOO_MANY_PRICES =
      "There are more than one price for given parameters. "
          + "This is an error in database data, please contact with support team";
  public static final String NOT_PRICE_FOUND = "There is no price with the given parameters";
  public static final String FIELD_CANT_BE_NULL = "must have a value.";
  public static final String SERVER_ERROR = "Server Error, please contact with support team";
}
