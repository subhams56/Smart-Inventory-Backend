package com.incedo.capstone.smartinventory.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public String exceptionHandler(UserNotFoundException unfe)
    {
        return "UserNotFoundException:";
    }

    @ExceptionHandler(UserCreationException.class)
    public ResponseEntity<String> handlingException(UserCreationException uce)
    {
        ResponseEntity<String> re = new ResponseEntity<>(uce.getMessage(), HttpStatus.BAD_REQUEST);
        return re;
    }

    @ExceptionHandler(UserIdNotFoundException.class)
    public ResponseEntity<String> handlingException(UserIdNotFoundException uinfe)
    {
        ResponseEntity<String> re = new ResponseEntity<>(uinfe.getMessage(), HttpStatus.BAD_REQUEST);
        return re;
    }

}
