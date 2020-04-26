package com.myworkout.api.controller;

import com.myworkout.api.entity.UserPhoto;
import com.myworkout.api.service.UserPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserPhotoController {


    private UserPhotoService userPhotoService;

    @Autowired
    public UserPhotoController(UserPhotoService userPhotoService) {
        this.userPhotoService = userPhotoService;
    }
}
