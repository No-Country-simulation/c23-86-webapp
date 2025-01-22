package com.callcenter.NoCountry.Exception;

public class ServiceException extends RuntimeException{
    
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
