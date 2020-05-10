package com.myworkout.api.service;

import com.myworkout.api.dto.PatchExercisePhotoDTO;
import com.myworkout.api.entity.Exercise;
import com.myworkout.api.entity.ExercisePhoto;
import com.myworkout.api.exception.ExercisePhotoNotFoundException;
import com.myworkout.api.repository.ExercisePhotoRepository;
import com.myworkout.api.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExercisePhotoService {

    private ExercisePhotoRepository exercisePhotoRepository;
    private ExerciseRepository exerciseRepository;


    @Autowired
    public ExercisePhotoService(ExercisePhotoRepository exercisePhotoRepository, ExerciseRepository exerciseRepository) {
        this.exercisePhotoRepository = exercisePhotoRepository;
        this.exerciseRepository = exerciseRepository;
    }

    public List<ExercisePhoto> getExercisePhotos(Long exerciseId){
        return exercisePhotoRepository.findAllByExerciseId(exerciseId);
    }

    public ExercisePhoto post(ExercisePhoto exercisePhoto) {
     return exercisePhotoRepository.save(exercisePhoto);

    }

    public void deleteExercisePhoto(Long id) {
        exercisePhotoRepository.deleteById(id);
    }

    public ExercisePhoto findById(Long id){
        return exercisePhotoRepository.findById(id).orElseThrow(()-> new ExercisePhotoNotFoundException()); // (ExercisePhotoNotFoundException::new)
    }

    public ExercisePhoto patchExercisePhoto(Long id, PatchExercisePhotoDTO patchExercisePhotoDTO) {
    ExercisePhoto exercisePhoto = findById(id);
    Exercise exercise = exerciseRepository.findById(patchExercisePhotoDTO.getExerciseId()).orElseThrow(()->new RuntimeException("todo"));
    exercisePhoto.setName(patchExercisePhotoDTO.getName());
    exercisePhoto.setUrl(patchExercisePhotoDTO.getUrl());
    exercisePhoto.setExercise(exercise);
    return exercisePhotoRepository.save(exercisePhoto);
    }
}
