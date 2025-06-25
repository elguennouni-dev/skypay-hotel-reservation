# Skypay Hotel Reservation

A simple hotel room reservation system written in Java. This project allows users to:

- Add new rooms and users.
- Book rooms based on availability and user balance.
- Display all current bookings and user information.

## Structure

- `Room`, `User`, and `Booking` entities.
- `Service` class for core business logic.
- Exception classes: `RoomNotAvailableException`, `InvalidBookingPeriodException`, `InsufficientBalanceException`...

## Features

- Prevents double-booking of rooms.
- Calculates total price based on number of nights.
- Validates booking periods and user balance.

## Run

Clone the repository and run `Main.java` using any Java IDE.
