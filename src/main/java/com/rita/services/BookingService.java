package com.rita.services;

import com.rita.entities.Reservation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BookingService {

    public Reservation clientRegister(Scanner sc) {

        System.out.print("Room number: ");
        Integer roomN = sc.nextInt();

        Map<String, LocalDate> dates = askDates(sc);

        return new Reservation(roomN, dates.get("checkIn"), dates.get("checkOut"));
    }

    public Map<String, LocalDate> askDates(Scanner sc){

        Map<String, LocalDate> map = new HashMap<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Check-in date (dd/MM/yyyy): ");
        LocalDate checkIn = LocalDate.parse(sc.next(), formatter);

        System.out.print("Check-out date (dd/MM/yyyy): ");
        LocalDate checkOut = LocalDate.parse(sc.next(), formatter);

        map.put("checkIn", checkIn);
        map.put("checkOut", checkOut);

        return map;
    }
}