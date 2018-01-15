package com.softel.service.exception;

/**
 * @version 1.0
 * @author: lsl
 * @description:
 * @date: Created in 10:49 2018/1/15
 * @modified By:
 */
public class ServiceException extends RootRuntimeException {
    private static final long serialVersionUID = 8284164474119891530L;

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    protected ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
