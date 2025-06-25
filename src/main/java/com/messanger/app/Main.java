package com.messanger.app;

import com.messanger.app.core.enums.RoomType;
import com.messanger.app.core.service.Service;

import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();

        service.setRoom(101, RoomType.STANDARD, 100);
        service.setRoom(102, RoomType.STANDARD, 150);
        service.setRoom(101, RoomType.STANDARD, 200);

        service.setUser(1, 500);
        service.setUser(2, 1000);
        service.setUser(1, 300);

        service.printAllUsers();
        service.printAll();

        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.JULY, 1);
        Date checkIn = calendar.getTime();


        calendar.set(2025, Calendar.JULY, 4);
        Date checkOut = calendar.getTime();

        try {
            service.bookRoom(1, 101, checkIn, checkOut);
        } catch (Exception e) {
            System.out.println("Booking failed: " + e.getMessage());
        }

        try {
            service.bookRoom(2, 101, checkIn, checkOut);
        } catch (Exception e) {
            System.out.println("Expected error (Room not available): " + e.getMessage());
        }

        service.printAll();
        service.printAllUsers();

    }
}