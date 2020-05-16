package com.myworkout.api.service;

import com.myworkout.api.ApiInfo;
import com.myworkout.api.dto.PatchTrainingDTO;
import com.myworkout.api.entity.Exercise;
import com.myworkout.api.entity.Training;
import com.myworkout.api.exception.NotFoundException;
import com.myworkout.api.repository.TrainingRepository;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainingService {

    private TrainingRepository trainingRepository;
    private List<Training> all;


    @Autowired
    public TrainingService(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    public List<Training> getTrainings() {//ok TODO NIE DZIALA!!!!!!!!!
//        return trainingRepository.findAllByHasExpiredFalse();

        return trainingRepository.findAll().stream()
                .filter(training -> !training.getHasExpired())
                .collect(Collectors.toList());
//
//        List<Training> all = trainingRepository.findAll();
//        all.removeIf(Training::getHasExpired);
//        return all;

    }

    public Training getTrainingsById(Long id) {
        return trainingRepository.findByIdAndHasExpiredFalse(id).orElseThrow(() -> new NotFoundException("Training not found..."));

/*       Training training = trainingRepository.findById(id).orElseThrow(() -> new NotFoundException("Training not found..."));
        if (training.getHasExpired()) {
            throw new NotFoundException("Training not found...");
        }
        return training;
* */

    }

    public Training postTraining(Training training) {
        return trainingRepository.save(training);
    }

    public void deleteById(Long id) {
        Training training = findById(id);
        training.setHasExpired(true);
        trainingRepository.save(training);
    }

    private Training findById(Long id) {
        return trainingRepository.findById(id).orElseThrow(() -> new NotFoundException("Training not found..."));
    }

    public Training updateTraining(Long id, PatchTrainingDTO patchTrainingDTO) {
        Training training = findById(id);
        if (patchTrainingDTO.getName() != null)
            training.setName(patchTrainingDTO.getName());
        if (patchTrainingDTO.getDescription() != null)
            training.setDescription(patchTrainingDTO.getDescription());

        return trainingRepository.save(training);
    }
}
