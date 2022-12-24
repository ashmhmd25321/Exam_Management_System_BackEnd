package com.exam.examinationsystem.helper;

public class UserNotFoundException extends Exception{
    public UserNotFoundException() {
        super("User not found..");
    }

    public UserNotFoundException(String msg) {
        super(msg);
    }
}
