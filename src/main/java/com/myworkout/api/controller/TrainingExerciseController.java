package com.myworkout.api.controller;

import com.myworkout.api.dto.TrainingExerciseDTO;
import com.myworkout.api.mapper.TrainingExercisesMapper;
import com.myworkout.api.service.TrainingExercisesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrainingExerciseController {


    private TrainingExercisesService trainingExercisesService;
    private TrainingExercisesMapper trainingExercisesMapper;

    @Autowired
    public TrainingExerciseController(TrainingExercisesService trainingExercisesService, TrainingExercisesMapper trainingExercisesMapper) {
        this.trainingExercisesService = trainingExercisesService;
        this.trainingExercisesMapper = trainingExercisesMapper;
    }

    @GetMapping("/trainings/{id}/exercises")
    public List<TrainingExerciseDTO> getExercises(@PathVariable Long id){
        return trainingExercisesMapper.toDTO(trainingExercisesService.getExercisesById(id));
    }

    @PostMapping("/trainings/{id}/exercises")
    public TrainingExerciseDTO postTrainingExercise(@PathVariable Long id, @RequestBody TrainingExerciseDTO trainingExerciseDTO){
        return trainingExercisesMapper.toDTO(trainingExercisesService.postTrainingExercise(id, trainingExerciseDTO));
    }


}
