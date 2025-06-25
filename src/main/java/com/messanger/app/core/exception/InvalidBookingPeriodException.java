package com.messanger.app.core.exception;

public class InvalidBookingPeriodException extends Exception{

    public InvalidBookingPeriodException() {
        super("Checkout date must be after checkin");
    }

    public InvalidBookingPeriodException(String customAlert) {
        super(customAlert);
    }

}
