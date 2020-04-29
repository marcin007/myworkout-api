package com.myworkout.api.controller;

import com.myworkout.api.ApiInfo;
import com.myworkout.api.dto.PatchUserDTO;
import com.myworkout.api.dto.PatchUserPhotoDTO;
import com.myworkout.api.dto.UserDTO;
import com.myworkout.api.dto.UserPhotoDTO;
import com.myworkout.api.entity.User;
import com.myworkout.api.entity.UserPhoto;
import com.myworkout.api.mapper.UserPhotoMapper;
import com.myworkout.api.service.UserPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserPhotoController {


    private UserPhotoService userPhotoService;
    private UserPhotoMapper userPhotoMapper;

    @Autowired
    public UserPhotoController(UserPhotoService userPhotoService, UserPhotoMapper userPhotoMapper) {
        this.userPhotoService = userPhotoService;
        this.userPhotoMapper = userPhotoMapper;
    }

    @GetMapping("/users/photos")
    public List<UserPhotoDTO> getUserPhotos(){
        return userPhotoMapper.toUserPhotoDTO(userPhotoService.getUserPhotos());
    }

    @GetMapping("/users/photos/{userPhoto_id}")
    public UserPhotoDTO getUserById(@PathVariable("userPhoto_id") Long id){
        return userPhotoMapper.toUserPhotoDTO(userPhotoService.findUserPhotoById(id));
    }

    @PostMapping("/users/photos")
    public UserPhotoDTO postUserPhoto(@RequestBody UserPhotoDTO userPhoto){
        return userPhotoMapper.toUserPhotoDTO(userPhotoService.postUserPhoto(userPhotoMapper.toUserPhotoEntity(userPhoto)));
    }

    @DeleteMapping("/users/photos/{id}")
    public ApiInfo deleteUserPhotoById(@PathVariable Long id){
        userPhotoService.deleteUserPhotoById(id);
        return new ApiInfo("Deleted user photo", HttpStatus.OK.value());
    }

    @PatchMapping("/users/photos/{id}")
    public UserPhoto updateUserPhotoById(@PathVariable Long id, @Valid @RequestBody PatchUserPhotoDTO userPhotoDTO){
        return userPhotoService.updateUserPhotoById(id, userPhotoDTO);
    }

}
