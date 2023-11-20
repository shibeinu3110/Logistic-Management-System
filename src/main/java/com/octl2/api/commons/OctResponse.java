package com.octl2.api.commons;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.octl2.api.helper.DateHelper;
import com.octl2.api.commons.suberror.ApiSubError;
import com.octl2.api.commons.exception.ErrorMessage;
import com.octl2.api.commons.exception.OctException;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Getter
public class OctResponse<T> {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateHelper.GLOBAL_DATE_TIME)
    private final LocalDateTime timestamp = LocalDateTime.now();
    private int code;
    private String message;
    private List<ApiSubError> details;
    private T data;
    private int total;

    public static <T> OctResponse<T> build(ErrorMessage errorMessage) {
        OctResponse<T> response = new OctResponse<>();
        response.code = errorMessage.getCode();
        response.message = errorMessage.getMessage();
        return response;
    }

    public static <T> OctResponse<T> build(ErrorMessage errorMessage, List<ApiSubError> details) {
        OctResponse<T> response = build(errorMessage);
        response.details = details;
        return response;
    }

    public static <T> OctResponse<T> build(T data) {
        OctResponse<T> response = new OctResponse<>();
        response.data = data;
        if (data instanceof Collection) {
            response.total = ((Collection<?>) data).size();
        }
        response.code = 200;
        return response;
    }

    public static <T> OctResponse<T> build(T data, Integer total) {
        OctResponse<T> response = build(data);
        response.total = total;
        return response;
    }

    public static <T> OctResponse<T> build(T data, ErrorMessage errorMessage) {
        OctResponse<T> response = build(errorMessage);
        response.data = data;
        return response;
    }

    public static <T> OctResponse<T> build(String message, Integer errCode) {
        OctResponse<T> response = new OctResponse<>();
        response.code = errCode;
        response.message = message;
        return response;
    }

    public static OctResponse<String> buildApplicationException(OctException exception) {
        return build(exception.getErrMsg());
    }
}