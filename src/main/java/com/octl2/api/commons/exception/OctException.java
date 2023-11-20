package com.octl2.api.commons.exception;

import lombok.Getter;

@Getter
public class OctException extends RuntimeException {
    private final ErrorMessage errMsg;

    public OctException(ErrorMessage errMsg) {
        super();
        this.errMsg = errMsg;
    }

    public OctException() {
        super();
        errMsg = null;
    }
}
