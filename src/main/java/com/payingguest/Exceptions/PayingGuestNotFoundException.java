package com.payingguest.Exceptions;

public class PayingGuestNotFoundException extends RuntimeException{

    public PayingGuestNotFoundException() {
    }

    public PayingGuestNotFoundException(String message) {
        super(message);
    }
}