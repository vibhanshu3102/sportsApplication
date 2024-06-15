package com.app.gloesports.controller;

import com.app.gloesports.dto.UserDto;
import com.app.gloesports.entity.User;
import com.app.gloesports.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

// It is a controller class that handles the user related requests
@RestController
@Validated
public class UserController {

    @Autowired
    UserService userService;
    // Add a user
    @PostMapping("/setuser")
    public UserDto setUserDetails(@Valid @RequestBody UserDto userDto){

        return  userService.addUser(userDto);
    }
    //Get a user by userId
    @GetMapping("/getuser/{userId}")
    public UserDto getUser(@PathVariable Long userId){
        return userService.getUserById(userId);
    }
}
