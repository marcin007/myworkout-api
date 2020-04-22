package com.myworkout.api.service;

import com.myworkout.api.repository.TrainingTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingTypeService {

    private TrainingTypeRepository trainingTypeRepository;


    @Autowired
    public TrainingTypeService(TrainingTypeRepository trainingTypeRepository) {
        this.trainingTypeRepository = trainingTypeRepository;
    }
}
