package com.myworkout.api.service;

import com.myworkout.api.dto.PatchExerciseDTO;
import com.myworkout.api.entity.BodyPart;
import com.myworkout.api.entity.Exercise;
import com.myworkout.api.entity.LevelOfAdvancement;
import com.myworkout.api.entity.User;
import com.myworkout.api.exception.BodyPartNotFoundException;
import com.myworkout.api.exception.LevelOfAdvancementNotFoundException;
import com.myworkout.api.exception.UserNotFoundException;
import com.myworkout.api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {

    private ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    private LevelOfAdvancementRepository levelOfAdvancementRepository;
    private BodyPartRepository bodyPartRepository;
    private UserRepository userRepository;
    private ExercisePhotoRepository exercisePhotoRepository;

    @Autowired
    public void setLevelOfAdvancementRepository(LevelOfAdvancementRepository levelOfAdvancementRepository) {
        this.levelOfAdvancementRepository = levelOfAdvancementRepository;
    }

    @Autowired
    public void setBodyPartRepository(BodyPartRepository bodyPartRepository) {
        this.bodyPartRepository = bodyPartRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setExercisePhotoRepository(ExercisePhotoRepository exercisePhotoRepository) {
        this.exercisePhotoRepository = exercisePhotoRepository;
    }

    public void deleteExerciseById(Long id){
        Exercise exercise = findById(id);
        exercise.setHasExpired(true);
        exerciseRepository.save(exercise);
    }

    public Exercise postExercise(Exercise exercise){
        return exerciseRepository.save(exercise);
    }

    public Exercise findById(Long id){
        return exerciseRepository.findById(id).orElseThrow(()->new RuntimeException("asd"));
    }

    public List<Exercise> getExercises() {
        return exerciseRepository.findAll();
    }

    public Exercise updateExercise(Long id, Exercise exercise) {
        Exercise existingExercise = findById(id);

        if (exercise.getName() != null) {
            existingExercise.setName(exercise.getName());
        }

        if (exercise.getBodyPart() != null) {
            existingExercise.setBodyPart(exercise.getBodyPart());
        }

        if (exercise.getLevelOfAdvancement() != null) {
            existingExercise.setLevelOfAdvancement(exercise.getLevelOfAdvancement());
        }

        return exerciseRepository.save(exercise);
    }
}
