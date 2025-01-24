package com.callcenter.NoCountry.Exception;


public class ControllerException extends RuntimeException{
    
    public ControllerException(String message, Throwable cause) {
        super(message, cause);
    }
}
