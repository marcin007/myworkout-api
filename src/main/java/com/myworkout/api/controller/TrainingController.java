package com.myworkout.api.controller;

import com.myworkout.api.ApiInfo;
import com.myworkout.api.dto.PatchTrainingDTO;
import com.myworkout.api.dto.TrainingDTO;
import com.myworkout.api.dto.TrainingDetailsDTO;
import com.myworkout.api.mapper.TrainingMapper;
import com.myworkout.api.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    @PostMapping("/trainings") //ok
    public TrainingDTO postTraining(@RequestBody TrainingDTO trainingDTO){
        return trainingMapper.toDTO(trainingService.postTraining(trainingMapper.toEntity(trainingDTO)));
    }

    @DeleteMapping("/trainings/{id}")// TODO NIEDZIALA !!!
    public ResponseEntity<ApiInfo> deleteTrainingById(@PathVariable Long id){
        trainingService.deleteById(id);
        return new ResponseEntity<>(new ApiInfo("Training deleted...", HttpStatus.OK.value()),HttpStatus.OK);
    }

    @PatchMapping("/trainings/{id}")//ok
    public TrainingDTO updateTraining(@PathVariable Long id, @RequestBody PatchTrainingDTO patchTrainingDTO){
        return trainingMapper.toDTO(trainingService.updateTraining(id, patchTrainingDTO));
    }





}
