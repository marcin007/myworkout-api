package com.myworkout.api.controller;

import com.myworkout.api.ApiInfo;
import com.myworkout.api.dto.ExerciseDTO;
import com.myworkout.api.dto.PatchExerciseDTO;
import com.myworkout.api.exception.ApiError;
import com.myworkout.api.mapper.ExerciseMapper;
import com.myworkout.api.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ExerciseController {

    private ExerciseService exerciseService;
    private ExerciseMapper exerciseMapper;


    @Autowired
    public ExerciseController(ExerciseService exerciseService, ExerciseMapper exerciseMapper) {
        this.exerciseService = exerciseService;
        this.exerciseMapper = exerciseMapper;
    }

    @GetMapping("/exercises/{id}")
    public ExerciseDTO getExerciseById(@PathVariable Long id){
       return exerciseMapper.toDTO(exerciseService.findById(id));
    }

    @GetMapping("/exercises")
    public List<ExerciseDTO> getExercise(){
        return exerciseMapper.toDTO(exerciseService.getExercises());
    }

    @PostMapping("/exercises")
    public ExerciseDTO postExercise(@RequestBody ExerciseDTO exerciseDTO){
        return exerciseMapper.toDTO(exerciseService.postExercise(exerciseMapper.toEntity(exerciseDTO)));
    }

    @DeleteMapping("/exercises/{id}")
    public ResponseEntity<ApiInfo> deleteExerciseById(@PathVariable Long id){
        exerciseService.deleteExerciseById(id);
        return new ResponseEntity<>(new ApiInfo("Deleted Exercise", HttpStatus.OK.value()), HttpStatus.OK);
    }

    @PatchMapping("/exercises/{id}")
    public ExerciseDTO updateExercise(@PathVariable Long id, @Valid @RequestBody PatchExerciseDTO patchExerciseDTO){
        return exerciseMapper.toDTO(exerciseService.updateExercise(id, exerciseMapper.fromPatchDtoToEntity(patchExerciseDTO)));
    }


}
