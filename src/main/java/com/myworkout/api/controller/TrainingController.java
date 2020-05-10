package com.myworkout.api.controller;

import com.myworkout.api.dto.TrainingDTO;
import com.myworkout.api.dto.TrainingDetailsDTO;
import com.myworkout.api.mapper.TrainingMapper;
import com.myworkout.api.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrainingController {

    private TrainingService trainingService;
    private TrainingMapper trainingMapper;

    @Autowired
    public TrainingController(TrainingService trainingService, TrainingMapper trainingMapper) {
        this.trainingService = trainingService;
        this.trainingMapper = trainingMapper;
    }

    @GetMapping("/trainings") //ok
    List<TrainingDTO> getTrainings(){
        return trainingMapper.toDTO(trainingService.getTrainings());
    }

    @GetMapping("/trainings/{id}")//ok
    TrainingDetailsDTO getTrainingDetailsDTO(@PathVariable Long id){
        return trainingMapper.toDetailsDTO(trainingService.getTrainingsById(id));
    }

    @PostMapping("/trainings") // todo NIE DZIALA !!  CZEMU???????????????
    public TrainingDTO postTraining(@RequestBody TrainingDTO trainingDTO){
        return trainingMapper.toDTO(trainingService.postTraining(trainingMapper.toEntity(trainingDTO)));
    }





}
