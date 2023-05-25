package com.rita;

import com.rita.entities.Reservation;
import com.rita.exceptions.DomainException;
import com.rita.services.BookingService;

import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BookingService bookingService = new BookingService();
        Reservation reservation = bookingService.clientRegister(sc);
        System.out.println(reservation.toString());

        try {
            System.out.println("Enter data to update the reservation: ");

            Map<String, LocalDate> dates = bookingService.askDates(sc);

            reservation.updateDates(dates.get("checkIn"), dates.get("checkOut"));
            System.out.println(reservation);
        }
        catch (DomainException e) {
            System.out.println("Error in reservation: " + e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Unexpected error");
        }
        catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        sc.close();
    }
}