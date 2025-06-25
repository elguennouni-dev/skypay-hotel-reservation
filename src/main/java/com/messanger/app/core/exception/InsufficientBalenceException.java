package com.messanger.app.core.exception;

public class InsufficientBalenceException extends Exception{

    public InsufficientBalenceException() {
        super("Not enough balance");
    }

    public InsufficientBalenceException(String customAlert) {
        super(customAlert);
    }

}
