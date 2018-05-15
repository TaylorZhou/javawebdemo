package com.test.zx.util;

/**
 * @author Taylor
 * @version 1.0
 */
public class ServiceException extends Exception {

    public ServiceException(String errorCode, String errorMsg) {
        super(errorCode);
    }
}
