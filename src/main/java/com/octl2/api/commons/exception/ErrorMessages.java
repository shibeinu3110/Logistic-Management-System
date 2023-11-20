package com.octl2.api.commons.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessages implements ErrorMessage {
    SUCCESS(200, "Success"),

    BAD_REQUEST(400, "Bad request"),
    INVALID_VALUE(400_001, "Invalid value"),
    SAVE_DATABASE_ERROR(400_002, "Save database error"),

    NOT_FOUND(404, "Resource not found"),
    ;

    private final int code;
    private final String message;
}
