package com.incedo.capstone.smartinventory.mapper;

import com.incedo.capstone.smartinventory.dto.UsersDto;
import com.incedo.capstone.smartinventory.entities.Users;

public class UsersMapper {
    public static UsersDto convertToDto(Users users) {
        UsersDto userDto = new UsersDto();
        userDto.setUserId(users.getUserId());
        userDto.setUsername(users.getUsername());
        userDto.setRole(users.getRole());
        userDto.setMobileNumber(users.getMobileNumber());
        userDto.setGender(users.getGender());
        return userDto;
    }
}