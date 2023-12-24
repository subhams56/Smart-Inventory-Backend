package com.incedo.capstone.smartinventory.controllers;

import com.incedo.capstone.smartinventory.dto.UsersDto;
import com.incedo.capstone.smartinventory.entities.Users;
import com.incedo.capstone.smartinventory.exceptions.IncorrectPasswordException;
import com.incedo.capstone.smartinventory.exceptions.UserIdNotFoundException;
import com.incedo.capstone.smartinventory.exceptions.UserNotFoundException;
import com.incedo.capstone.smartinventory.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UsersController {


    @Autowired
    UsersService usersService;

    @PostMapping("/addUsers")
    public ResponseEntity<String> addUser(@RequestBody Users user) {
        String message = usersService.addUser(user);
        ResponseEntity<String> re = new ResponseEntity<>(message, HttpStatus.CREATED);
        return re;
    }

    @PutMapping("/{username}")
    public ResponseEntity<Object> updateUserByUsername(
            @PathVariable("username") String username,
            @RequestBody UsersDto updatedUserDto) {

        try {
            UsersDto updatedUser = usersService.updateUser(username, updatedUserDto);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } catch (UserNotFoundException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while updating the user.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public List<UsersDto> fetchUsers()
    {
        return usersService.fetchUsers();
    }



    @GetMapping("/{username}")
    public ResponseEntity<Object> getUserById(@PathVariable("username") String username) {
        try {
            UsersDto userDto = usersService.fetchUserByName(username);
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        } catch (UserNotFoundException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{username}")
    public ResponseEntity<String> deleteUserByUsername(@PathVariable("username") String username) {
        try {
            String result = usersService.deleteUser(username);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (UserNotFoundException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while deleting the user.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @PostMapping("/authenticateUsers")
    public ResponseEntity<Object> authenticateUser(@RequestBody Users user) {
        try {
            UsersDto authenticatedUser = usersService.authenticateUser(user);
            return new ResponseEntity<>(authenticatedUser, HttpStatus.OK);
        } catch (UserNotFoundException | IncorrectPasswordException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while authenticating the user.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
