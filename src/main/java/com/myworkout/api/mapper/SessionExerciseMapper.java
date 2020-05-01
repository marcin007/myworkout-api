package com.myworkout.api.mapper;

import com.myworkout.api.dto.SessionExerciseDTO;
import com.myworkout.api.entity.SessionExercise;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface SessionExerciseMapper {

    @Mappings({
            @Mapping(target = "sessionId", source = "session.id"),
            @Mapping(target = "exerciseId", source = "exercise.id")
    })
    SessionExerciseDTO toDto(SessionExercise se);
    List<SessionExerciseDTO> toDto(Collection<SessionExercise> se);
}
