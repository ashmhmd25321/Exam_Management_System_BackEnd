package com.exam.examinationsystem.helper;

public class UserFoundException extends Exception{
    public UserFoundException() {
        super("User with this Username already in the DB.. Try with another username..");
    }

    public UserFoundException(String msg) {
        super(msg);
    }
}
