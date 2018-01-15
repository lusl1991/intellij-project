package com.softel.exception;

import com.softel.service.exception.RootRuntimeException;

/**
 * @version 1.0
 * @author: lsl
 * @description:
 * @date: Created in 10:51 2018/1/15
 * @modified By:
 */
public class BusinessException extends RootRuntimeException {
    private static final long serialVersionUID = 8284164474119891530L;

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    protected BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
