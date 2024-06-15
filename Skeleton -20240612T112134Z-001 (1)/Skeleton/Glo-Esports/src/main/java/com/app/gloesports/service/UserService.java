package com.app.gloesports.service;

import com.app.gloesports.dto.UserDto;
import com.app.gloesports.entity.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

/*
    make this into a service layer for User entity
    and implement the methods from UserService interface.
 */
@Service
public interface UserService {
    // Add a user
    UserDto addUser(UserDto userDto);
    // Get a user by userId
    UserDto getUserById(Long userId);
}
