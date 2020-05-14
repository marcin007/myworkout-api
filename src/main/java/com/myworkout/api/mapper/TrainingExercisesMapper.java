package com.myworkout.api.mapper;

import com.myworkout.api.dto.TrainingExerciseDTO;
import com.myworkout.api.entity.TrainingExercise;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class TrainingExercisesMapper {

    @Mappings({
            @Mapping(target = "trainingId", source = "training.id"),
            @Mapping(target = "exerciseId", source = "exercise.id")
    })
    public abstract TrainingExerciseDTO toDTO(TrainingExercise trainingExercise);
    public abstract List<TrainingExerciseDTO> toDTO(Collection<TrainingExercise> trainingExercises);

}
