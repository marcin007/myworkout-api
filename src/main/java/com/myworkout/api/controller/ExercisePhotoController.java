package com.myworkout.api.controller;


import com.myworkout.api.entity.ExercisePhoto;
import com.myworkout.api.service.ExercisePhotoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Table;
import java.util.List;
import java.util.Set;

@RestController
public class ExercisePhotoController{

    private ExercisePhotoService exercisePhotoService;

    @Autowired
    public ExercisePhotoController(ExercisePhotoService exercisePhotoService) {
        this.exercisePhotoService = exercisePhotoService;
    }


    @GetMapping("/exercise/exercisePhotos")//TODO czy to wina braku mapera?
    public List<ExercisePhoto> getExercisePhotos(){
        return exercisePhotoService.getExercisePhotos();
    }



}
