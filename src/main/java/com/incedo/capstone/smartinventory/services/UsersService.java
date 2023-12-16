package com.incedo.capstone.smartinventory.services;

import com.incedo.capstone.smartinventory.entities.Users;
import com.incedo.capstone.smartinventory.exceptions.UserCreationException;
import com.incedo.capstone.smartinventory.exceptions.UserIdNotFoundException;
import com.incedo.capstone.smartinventory.exceptions.UserNotFoundException;
import com.incedo.capstone.smartinventory.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {


    @Autowired
    UsersRepository usersRepository;

//    public String addUser(Users user) {
//        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
//        String encryptedPwd = bcrypt.encode(user.getPwd());
//        user.setPwd(encryptedPwd);
//        Users savedUser = usersRepository.save(user);
//        if(savedUser!= null)
//            return savedUser+" added to database Successfully";
//        else
//            throw new UserCreationException("There is Some Problem Creating the User");
//
//    }

    public String addUser(Users user) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        String encryptedPwd = bcrypt.encode(user.getPwd());
        user.setPwd(encryptedPwd);
        Users savedUser = usersRepository.save(user);
        if (savedUser != null) {
            return successMessage(savedUser);
        } else {
            throw new UserCreationException("There is Some Problem Creating the User");
        }
    }

    private String successMessage(Users user) {
        return String.format("User Successfully Added%nusername='%s',%nuserId=%d,%nrole='%s',%nmobileNumber=%s,%ngender='%s'",
                user.getUsername(), user.getUserId(), user.getRole(), user.getMobileNumber(), user.getGender());
    }

//    public Users authenticateUser(Users user) {
//
//        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
//
//        Optional<Users> opUser = usersRepository.findById(user.getUsername());
//        if (opUser.isPresent()) {
//            Users dbUser = opUser.get();
//            if(bcrypt.matches(user.getPwd(),dbUser.getPwd()))
//            {
//                return dbUser;
//            } else {
//                throw new RuntimeException("Incorrect Password");
//            }
//        } else
//            throw new UserNotFoundException("No User is found for this username");
//    }
//    private String authSuccessMessage(Users user) {
//        return String.format("User Successfully Logged In %nusername='%s',%nuserId=%d,%nrole='%s',%nmobileNumber=%s,%ngender='%s'",
//                user.getUsername(), user.getUserId(), user.getRole(), user.getMobileNumber(), user.getGender());
//    }

    public Users authenticateUser(Users user) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();

        Optional<Users> opUser = usersRepository.findById(user.getUsername());
        if (opUser.isPresent()) {
            Users dbUser = opUser.get();
            if (bcrypt.matches(user.getPwd(), dbUser.getPwd())) {
                // Remove password from the response
                dbUser.setPwd(null);
                return dbUser;
            } else {
                throw new RuntimeException("Incorrect Password");
            }
        } else {
            throw new UserNotFoundException("No User is found for this username");
        }
    }

    public String updateUser(Users user, String username) {
        if(usersRepository.existsById(user.getUsername()))
        {
            BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
            String encryptedPwd = bcrypt.encode(user.getPwd());
            user.setPwd(encryptedPwd);
            Users userDB = usersRepository.save(user);
            if(userDB != null)
            {
                return "Updated User Successfully";
            }
            else {
                throw new UserNotFoundException("Error Updating User");
            }
        }
        throw new UserIdNotFoundException("No Records found for user with id: "+username);
    }

    public List<Users> fetchUsers() {
        return usersRepository.findAll();
    }

//    public Users fetchUserById(int userId) {
//        Optional<Users> op = usersRepository.findById()
//    }

    public Users fetchUserByName(String username) {
        Optional<Users> op = usersRepository.findById(username);
        if(op.isPresent())
            return op.get();
        else
            throw new UserNotFoundException("No Record found for the user: " +username);
    }

    public String deleteuser(String username) {
        if(usersRepository.existsById(username))
        {
            usersRepository.deleteById(username);
            return "user Successfully Deleted";
        }
        else
            throw new UserIdNotFoundException("No Record found for user: "+username);
    }
}
