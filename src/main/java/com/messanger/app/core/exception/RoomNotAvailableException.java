package com.messanger.app.core.exception;

public class RoomNotAvailableException extends Exception{

    public RoomNotAvailableException(boolean notFound) {
        super("Room not found");
    }

    public RoomNotAvailableException() {
        super("Room already booked in this period");
    }

    public RoomNotAvailableException(String customAlert) {
        super(customAlert);
    }


}
