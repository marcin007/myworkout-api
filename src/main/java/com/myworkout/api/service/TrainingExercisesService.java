package com.myworkout.api.service;

import com.myworkout.api.repository.TrainingExercisesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingExercisesService {

    private TrainingExercisesRepository trainingExercisesRepository;

    @Autowired
    public TrainingExercisesService(TrainingExercisesRepository trainingExercisesRepository) {
        this.trainingExercisesRepository = trainingExercisesRepository;
    }
}
