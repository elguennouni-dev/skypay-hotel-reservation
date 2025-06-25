package com.messanger.app.core.service;

import com.messanger.app.core.entity.Booking;
import com.messanger.app.core.entity.Room;
import com.messanger.app.core.entity.User;
import com.messanger.app.core.enums.RoomType;
import com.messanger.app.core.exception.InsufficientBalenceException;
import com.messanger.app.core.exception.InvalidBookingPeriodException;
import com.messanger.app.core.exception.RoomNotAvailableException;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;

public class Service {
    ArrayList<Room> rooms;
    ArrayList<User> users;
    ArrayList<Booking> bookings;

    public Service() {
        rooms = new ArrayList<>();
        users = new ArrayList<>();
        bookings = new ArrayList<>();
    }

    public void setRoom(int roomNumber, RoomType roomType, int price) {
        if (rooms.isEmpty()) {
            rooms.add(new Room(roomNumber, roomType, price));
            return;
        }

        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) return;
        }
        rooms.add(new Room(roomNumber, roomType, price));
    };

    public void setUser(int userId, int balance) {
        if (users.isEmpty()) {
            users.add(new User(userId, balance));
            return;
        }

        for (User user : users) {
            if (user.getUserId() == userId) return;
        }
        users.add(new User(userId, balance));
    };

    public void bookRoom(int userId, int roomNumber, Date checkIn, Date checkOut) throws RoomNotAvailableException, InvalidBookingPeriodException, InsufficientBalenceException {
        Room curentRoom = null;
        User currentUser = null;

        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                curentRoom = room;
                break;
            }
        }

        if (curentRoom == null) {
            throw new RoomNotAvailableException(true);
        }

        for (User user : users) {
            if (user.getUserId() == userId) {
                currentUser = user;
                break;
            }
        }

        if (currentUser == null) {
            throw new RuntimeException("User not found");
        }

        if (checkOut.before(checkIn)) {
            throw new InvalidBookingPeriodException();
        }

        ZoneId zone = ZoneId.systemDefault();
        LocalDate checkInDate = checkIn.toInstant().atZone(zone).toLocalDate();
        LocalDate checkOutDate = checkOut.toInstant().atZone(zone).toLocalDate();
        long nights = ChronoUnit.DAYS.between(checkInDate, checkOutDate);

        int totalPrice = curentRoom.getPricePerNight() * (int) nights;

        if (currentUser.getBalance() < totalPrice) {
            throw new InsufficientBalenceException();
        }

        for (Booking booking : bookings) {
            if (booking.getRoom().getRoomNumber() == roomNumber) {
                boolean overlap = !(checkOut.before(booking.getCheckIn()) || checkIn.after(booking.getCheckOut()));
                if (overlap) {
                    throw new RoomNotAvailableException();
                }
            }
        }

        Booking newBooking = new Booking(curentRoom, currentUser, checkIn, checkOut, totalPrice);
        newBooking.setFirstBalance(currentUser.getBalance());
        bookings.add(newBooking);
        currentUser.setBalance(currentUser.getBalance() - totalPrice);
    };

    public void printAll() {
        String information = "--- ROOMS ---\n";
        for (int size = rooms.size()-1; size >= 0; size--) {
            information += "Room Number: " + rooms.get(size).getRoomNumber()
                    + " | Type: " + rooms.get(size).getRoomType()
                    + " | Price Per Night: " + rooms.get(size).getPricePerNight() + "\n";
        }
        information += "\n\n--- BOOKINGS ---\n";
        for (int size = bookings.size()-1; size >= 0; size--) {
            information += "User Id: " + bookings.get(size).getUsers().getUserId()
                    + " | First Balance: " + bookings.get(size).getFirstBalance()
                    + " | Room Number: " + bookings.get(size).getRoom().getRoomNumber()
                    + " | Type: " + bookings.get(size).getRoom().getRoomType()
                    + " | Price Per Night: " + bookings.get(size).getRoom().getPricePerNight()
                    + "\nCheck In: " + bookings.get(size).getCheckIn()
                    + " | Check Out: " + bookings.get(size).getCheckOut()
                    + "\n\n";
        }

        System.out.println(information);
    };
    public void printAllUsers() {
        String usersInformation = "--- All Users ---\n";
        for (int size = users.size()-1; size >= 0; size--) {
            usersInformation += "User Id: " + users.get(size).getUserId()
                    + " | Balance: " + users.get(size).getBalance()
                    + "\n";
        }
        System.out.println(usersInformation);
    };

}
