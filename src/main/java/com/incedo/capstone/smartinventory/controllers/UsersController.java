package com.incedo.capstone.smartinventory.controllers;

import com.incedo.capstone.smartinventory.entities.Users;
import com.incedo.capstone.smartinventory.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {


    @Autowired
    UsersService usersService;

    @PostMapping("/addUsers")
    public ResponseEntity<String> addUser(@RequestBody Users user)
    {
        String message = usersService.addUser(user);
        ResponseEntity<String> re = new ResponseEntity<String>(message, HttpStatus.CREATED);
        return re;
    }

    @PutMapping("/users/{username}")


    public ResponseEntity<String>  Updateuser(@RequestBody Users user, @PathVariable("username") String username)
    {
        String message = usersService.updateUser(user,username);
        ResponseEntity<String> re = new ResponseEntity<String>(message, HttpStatus.OK);
        return re;
    }

    @GetMapping("/users")
    public List<Users> fetchUsers()
    {
        return usersService.fetchUsers();
    }

//    @GetMapping("users/{userId}")
//            public Users getUserById(@PathVariable("userId") int userId)
//    {
//        return usersService.fetchUserById(userId);
//    }

    @GetMapping("/users/{username}")
    public Users getUserById(@PathVariable("username") String username)
    {
        return usersService.fetchUserByName(username);
    }

    @DeleteMapping("/users/{username}")
    public String deleteUser(@PathVariable("username") String username)
    {
        return usersService.deleteuser(username);
    }



    @PostMapping("/authenticateUsers")
    public String authenticateUser(@RequestBody Users user)
    {
        return usersService.authenticateUser(user);
    }
}
