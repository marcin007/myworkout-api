package com.myworkout.api.controller;

import com.myworkout.api.ApiInfo;
import com.myworkout.api.dto.ExercisePhotoDTO;
import com.myworkout.api.dto.PatchExercisePhotoDTO;
import com.myworkout.api.mapper.ExercisePhotoMapper;
import com.myworkout.api.service.ExercisePhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExercisePhotoController {

    private ExercisePhotoService exercisePhotoService;
    private ExercisePhotoMapper exercisePhotoMapper;

    @Autowired
    public ExercisePhotoController(ExercisePhotoService exercisePhotoService, ExercisePhotoMapper exercisePhotoMapper) {
        this.exercisePhotoService = exercisePhotoService;
        this.exercisePhotoMapper = exercisePhotoMapper;
    }


    @GetMapping("/exercises/{id}/photos")
    public List<ExercisePhotoDTO> getExercisePhotos(@PathVariable Long id) {
        return exercisePhotoMapper.toDTO(exercisePhotoService.getExercisePhotos(id));

    }

    @PostMapping("/exercises/photos")
    public ExercisePhotoDTO postExercisePhoto(@RequestBody ExercisePhotoDTO exercisePhotoDTO){
        return exercisePhotoMapper.toDTO(exercisePhotoService.post(exercisePhotoMapper.toEntity(exercisePhotoDTO)));
    }

    @DeleteMapping("/exercises/{id}/photos")
    public ResponseEntity<ApiInfo> deleteExercisePhoto(@PathVariable Long id){
        exercisePhotoService.deleteExercisePhoto(id);
        return new ResponseEntity<>(new ApiInfo("Deleted exercise photo", HttpStatus.OK.value()), HttpStatus.OK);

    }

    @PatchMapping("/exercises/{id}/photos")
    public ExercisePhotoDTO updateExercisePhoto(@PathVariable Long id, @RequestBody PatchExercisePhotoDTO patchExercisePhotoDTO){
        return exercisePhotoMapper.toDTO(exercisePhotoService.patchExercisePhoto(id, patchExercisePhotoDTO));
    }

}
