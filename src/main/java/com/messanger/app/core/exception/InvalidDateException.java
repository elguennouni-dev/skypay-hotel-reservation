package com.messanger.app.core.exception;

public class InvalidDateException extends Exception{

    public InvalidDateException() {
        super("");
    }

    public InvalidDateException(String customAlert) {
        super(customAlert);
    }

}
