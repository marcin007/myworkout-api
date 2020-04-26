package com.myworkout.api.service;

import com.myworkout.api.entity.ExercisePhoto;
import com.myworkout.api.repository.ExercisePhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExercisePhotoService {

    private ExercisePhotoRepository exercisePhotoRepository;

    @Autowired
    public ExercisePhotoService(ExercisePhotoRepository exercisePhotoRepository) {
        this.exercisePhotoRepository = exercisePhotoRepository;
    }

    public List<ExercisePhoto> getExercisePhotos(){
        return exercisePhotoRepository.findAll();
    }

}
