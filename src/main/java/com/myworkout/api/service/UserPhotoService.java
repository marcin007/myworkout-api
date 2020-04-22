package com.myworkout.api.service;


import com.myworkout.api.entity.UserPhoto;
import com.myworkout.api.repository.UserPhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPhotoService {

    private UserPhotoRepository userPhotoRepository;

    @Autowired
    public UserPhotoService(UserPhotoRepository userPhotoRepository) {
        this.userPhotoRepository = userPhotoRepository;
    }
}
