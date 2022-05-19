package com.payingguest.Exceptions;

public class BookingNotFoundException extends RuntimeException{

    public BookingNotFoundException() {
    }

    public BookingNotFoundException(String message) {
        super(message);
    }
}