package com.incedo.capstone.smartinventory.exceptions;

public class UserIdNotFoundException extends RuntimeException{

    public UserIdNotFoundException(String message)
    {
        super(message);
    }
}
