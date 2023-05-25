package com.rita.entities;

import com.rita.exceptions.DomainException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

public class Reservation {

    private Integer roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) {
        if (!checkOut.isAfter(checkIn)) {
            throw new DomainException("Check-out date must be after check-in date");
        }
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public long duration(){
        return ChronoUnit.DAYS.between(checkIn, checkOut);
    }

    public void updateDates(LocalDate checkIn, LocalDate checkOut){
        if (checkIn.isBefore(checkIn) || checkOut.isBefore(checkOut)) {
            throw new DomainException("Reservation dates for update must be future dates");
        }
        if (!checkOut.isAfter(checkIn)) {
            throw new DomainException("Check-out date must be after check-in date");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString (){

        String roomNumber = "Room number " + getRoomNumber() +  ", " ;
        String checkIn = "Check-in: " + getCheckIn() +  ", ";
        String checkOut = "Check-out: " + getCheckOut() + ". ";

        return "Reservation: " + roomNumber + checkIn + checkOut + duration() + " nights.";
    }
}