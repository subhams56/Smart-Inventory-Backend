package com.incedo.capstone.smartinventory.services;

import com.incedo.capstone.smartinventory.dto.UsersDto;
import com.incedo.capstone.smartinventory.entities.Users;
import com.incedo.capstone.smartinventory.exceptions.IncorrectPasswordException;
import com.incedo.capstone.smartinventory.exceptions.UserCreationException;
import com.incedo.capstone.smartinventory.exceptions.UserIdNotFoundException;
import com.incedo.capstone.smartinventory.exceptions.UserNotFoundException;
import com.incedo.capstone.smartinventory.mapper.UsersMapper;
import com.incedo.capstone.smartinventory.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsersService {


    @Autowired
    UsersRepository usersRepository;




    public String addUser(Users user) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        String encryptedPwd = bcrypt.encode(user.getPwd());
        user.setPwd(encryptedPwd);
        Users savedUser = usersRepository.save(user);
        if (savedUser != null) {
            return "User Created";
        } else {
            throw new UserCreationException("There is Some Problem Creating the User");
        }
    }


    public UsersDto authenticateUser(Users user) {
        // Find user by username
        Users existingUser = usersRepository.findByUsername(user.getUsername());

        if (existingUser != null) {
            // Check if the provided password matches the stored hashed password
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            if (passwordEncoder.matches(user.getPwd(), existingUser.getPwd())) {
                // Passwords match, return the user DTO
                return UsersMapper.convertToDto(existingUser);
            } else {
                // Passwords do not match, throw an exception
                throw new IncorrectPasswordException("Incorrect password for user: " + user.getUsername());
            }
        } else {
            // User does not exist, throw an exception
            throw new UserNotFoundException("User not found: " + user.getUsername());
        }
    }






    public UsersDto updateUser(String username, UsersDto updatedUserDto) {
        // Find the existing user by username
        Users existingUser = usersRepository.findByUsername(username);

        if (existingUser != null) {
            // Update the user with the new values
            existingUser.setRole(updatedUserDto.getRole());
            existingUser.setMobileNumber(updatedUserDto.getMobileNumber());
            existingUser.setGender(updatedUserDto.getGender());

            // Save the updated user
            Users updatedUser = usersRepository.save(existingUser);

            // Convert and return the updated user DTO
            return UsersMapper.convertToDto(updatedUser);
        } else {
            throw new UserNotFoundException("User not found with username: " + username);
        }
    }

    public List<UsersDto> fetchUsers(){
       return usersRepository.findAll()
               .stream().
               map(UsersMapper::convertToDto).
               collect(Collectors.toList());
    }


    public UsersDto fetchUserByName(String username) {
        Users user = usersRepository.findByUsername(username);
        if (user != null) {
            return UsersMapper.convertToDto(user);
        } else {
            throw new UserNotFoundException("No Record found for the user: " + username);
        }
    }



    public String deleteUser(String username) {
        Users user = usersRepository.findByUsername(username);
        if (user != null) {
            usersRepository.delete(user);
            return "User Successfully Deleted";
        } else {
            throw new UserNotFoundException("No Record found for user: " + username);
        }
    }

}
