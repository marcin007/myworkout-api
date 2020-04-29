package com.myworkout.api.service;


import com.myworkout.api.dto.PatchUserDTO;
import com.myworkout.api.dto.PatchUserPhotoDTO;
import com.myworkout.api.dto.UserPhotoDTO;
import com.myworkout.api.entity.User;
import com.myworkout.api.entity.UserPhoto;
import com.myworkout.api.repository.UserPhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserPhotoService {

    private UserPhotoRepository userPhotoRepository;

    @Autowired
    public UserPhotoService(UserPhotoRepository userPhotoRepository) {
        this.userPhotoRepository = userPhotoRepository;
    }

    public List<UserPhoto> getUserPhotos(){
        return userPhotoRepository.findAll();
    }

    public UserPhoto findUserPhotoById(Long id){ //TODO -> do poprawy blad
        return userPhotoRepository.findById(id).orElseThrow(()-> new RuntimeException("dsa"));
    }

    public void deleteUserPhotoById(Long id){
        userPhotoRepository.deleteById(id);
    }

    public UserPhoto updateUserPhotoById(Long id, PatchUserPhotoDTO patchUserPhotoDTO){
        UserPhoto userPhoto = findUserPhotoById(id);
        userPhoto.setUrl(patchUserPhotoDTO.getUrl());
        return userPhotoRepository.save(userPhoto);
    }

    public UserPhoto postUserPhoto(UserPhoto userPhoto){
        return userPhotoRepository.save(userPhoto);
    }


}
