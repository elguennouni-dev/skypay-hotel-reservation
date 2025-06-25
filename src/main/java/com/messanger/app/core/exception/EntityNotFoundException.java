package com.messanger.app.core.exception;

public class EntityNotFoundException extends Exception{

    public EntityNotFoundException() {
        super("");
    }

    public EntityNotFoundException(String customAlert) {
        super(customAlert);
    }

}
