package com.messanger.app.core.entity;

import java.util.Date;

public class Booking {

    private Room room;
    private User users;
    private Date checkIn;
    private Date checkOut;
    private int firstBalance;

    public Booking() {

    };

    public Booking(Room room, User users, Date checkIn, Date checkOut, int firstBalance) {
        this.room = room;
        this.users = users;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.firstBalance = firstBalance;
    }


    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public int getFirstBalance() {
        return firstBalance;
    }

    public void setFirstBalance(int firstBalance) {
        this.firstBalance = firstBalance;
    }


}
