package com.incedo.capstone.smartinventory.exceptions;

    public class UserNotFoundException extends RuntimeException{
        public UserNotFoundException(String message)
        {
            super(message);
        }
    }
