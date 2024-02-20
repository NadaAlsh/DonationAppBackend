package com.nada.DonationApp.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String str) {
        super(str);
    }
}
