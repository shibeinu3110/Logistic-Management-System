package com.octl2.api.commons.exception;

import java.io.Serializable;

public interface ErrorMessage extends Serializable {

    int getCode();

    String getMessage();
}
