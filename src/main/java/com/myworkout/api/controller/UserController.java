package com.myworkout.api.controller;

import com.myworkout.api.ApiInfo;
import com.myworkout.api.dto.PatchUserDTO;
import com.myworkout.api.dto.UserDTO;
import com.myworkout.api.entity.User;
import com.myworkout.api.mapper.UserMapper;
import com.myworkout.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
public class UserController {

    private UserService userService;
    private UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }


    @GetMapping("/users")
    public List<UserDTO> getUsers(){
        return userMapper.toUserDTO(userService.getUsers());
    }

    @GetMapping("/users/{user_id}")
    public UserDTO getUserById(@PathVariable("user_id") Long id){
        return userMapper.toUserDTO(userService.findUserById(id));
    }

    @PostMapping("/users")
    public UserDTO postUser(@RequestBody UserDTO user){
        return userMapper.toUserDTO(userService.postUser(userMapper.toUserEntity(user)));
    }

    @DeleteMapping("/users/{id}")
    public ApiInfo deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
        return new ApiInfo("Deleted user", HttpStatus.OK.value());
    }

    @PatchMapping("/users/{id}")
    public User updateUserById(@PathVariable Long id, @Valid @RequestBody PatchUserDTO userDTO){
        return userService.updateUserById(id, userDTO);
    }


}
