package com.myworkout.api.service;

import com.myworkout.api.dto.TrainingExerciseDTO;
import com.myworkout.api.entity.TrainingExercise;
import com.myworkout.api.repository.TrainingExercisesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class TrainingExercisesService {

    private TrainingExercisesRepository trainingExercisesRepository;

    @Autowired
    public TrainingExercisesService(TrainingExercisesRepository trainingExercisesRepository) {
        this.trainingExercisesRepository = trainingExercisesRepository;
    }

    public List<TrainingExercise> getExercisesById(Long id) {
        return trainingExercisesRepository.findAllByTrainingId(id);
    }

    public TrainingExercise postTrainingExercise(Long id, TrainingExerciseDTO trainingExerciseDTO) {
        TrainingExercise trainingExercise = trainingExercisesRepository.findByTrainingId(id);
        if(trainingExerciseDTO.getReps() != null)
        trainingExercise.setReps(trainingExerciseDTO.getReps());
        if(trainingExerciseDTO.getSets()!= null)
            trainingExercise.setSets(trainingExerciseDTO.getSets());
        if(trainingExerciseDTO.getTime()!= null)
            trainingExercise.setTime(trainingExerciseDTO.getTime());
        return trainingExercisesRepository.save(trainingExercise);
    }
}
