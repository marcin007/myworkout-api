package com.myworkout.api.mapper;

import com.myworkout.api.dto.ExercisePhotoDTO;
import com.myworkout.api.entity.Exercise;
import com.myworkout.api.entity.ExercisePhoto;
import com.myworkout.api.repository.ExercisePhotoRepository;
import com.myworkout.api.repository.ExerciseRepository;
import lombok.AllArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ExercisePhotoMapper {

   private ExerciseRepository exerciseRepository;

   @Autowired
    public void setExerciseRepository(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @Mappings({
            @Mapping(target = "exerciseId", source = "exercise.id")
    })
    public abstract ExercisePhotoDTO toDTO(ExercisePhoto exercisePhoto);
    public abstract List<ExercisePhotoDTO> toDTO (Collection<ExercisePhoto> exercisePhoto);


    public ExercisePhoto toEntity(ExercisePhotoDTO exercisePhotoDTO){
        ExercisePhoto exercisePhoto = new ExercisePhoto();
        Exercise exercise = exerciseRepository.findById(exercisePhotoDTO.getExerciseId()).orElseThrow(()-> new RuntimeException("cant find."));
        exercisePhoto.setExercise(exercise);
        exercisePhoto.setName(exercisePhotoDTO.getName());
        exercisePhoto.setUrl(exercisePhotoDTO.getUrl());
        return exercisePhoto;
    }



}
