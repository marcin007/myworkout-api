package com.myworkout.api.service;

import com.myworkout.api.entity.Training;
import com.myworkout.api.exception.NotFoundException;
import com.myworkout.api.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class TrainingService {

    private TrainingRepository trainingRepository;

    @Autowired
    public TrainingService(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    public List<Training> getTrainings() {
        return trainingRepository.findAll();
    }

    public Training getTrainingsById(Long id) {
        return trainingRepository.findById(id).orElseThrow(()-> new NotFoundException("Training not found..."));
    }

    public Training postTraining(Training training) {
     return trainingRepository.save(training);
    }
}
