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
    NULL_EXCEPTION(400_000, "Null value"),
    LOCATION_SMALLER_THAN_LEVEL_MAPPING(600, "Location is smaller than level mapping"),
    PROVINCE_NOT_FOUND(404_01,"Can't find province with this ID"),
    DISTRICT_NOT_FOUND(404_01,"Can't find district with this ID"),
    SUB_DISTRICT_NOT_FOUND(404_01,"Can't find sub district with this ID")
    ;

    private final int code;
    private final String message;
}
