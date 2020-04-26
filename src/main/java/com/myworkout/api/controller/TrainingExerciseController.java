package com.myworkout.api.controller;

import com.myworkout.api.entity.TrainingExercise;
import com.myworkout.api.service.TrainingExercisesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrainingExerciseController {


    private TrainingExercisesService trainingExercisesService;

    @Autowired
    public TrainingExerciseController(TrainingExercisesService trainingExercisesService) {
        this.trainingExercisesService = trainingExercisesService;
    }
}
