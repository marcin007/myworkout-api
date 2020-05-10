package com.myworkout.api.mapper;

import com.myworkout.api.dto.SessionExerciseDTO;
import com.myworkout.api.entity.Exercise;
import com.myworkout.api.entity.Session;
import com.myworkout.api.entity.SessionExercise;
import com.myworkout.api.entity.SessionExerciseId;
import com.myworkout.api.exception.ExerciseNotFoundException;
import com.myworkout.api.exception.SessionNotFoundException;
import com.myworkout.api.repository.ExerciseRepository;
import com.myworkout.api.repository.SessionRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class SessionExerciseMapper {

    private SessionRepository sessionRepository;
    private ExerciseRepository exerciseRepository;

    @Autowired
    public void setSessionRepository(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @Autowired
    public void setExerciseRepository(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @Mappings({
            @Mapping(target = "sessionId", source = "session.id"),
            @Mapping(target = "exerciseId", source = "exercise.id")
    })
    public abstract SessionExerciseDTO toDto(SessionExercise se);
    public abstract List<SessionExerciseDTO> toDto(Collection<SessionExercise> se);

    public SessionExercise toEntity(SessionExerciseDTO sessionExerciseDTO){
        SessionExercise sessionExercise = new SessionExercise();
        SessionExerciseId sessionExerciseId = new SessionExerciseId();
        Session session = sessionRepository.findById(sessionExerciseDTO.getSessionId()).orElseThrow(()-> new SessionNotFoundException());
        Exercise exercise = exerciseRepository.findById(sessionExerciseDTO.getExerciseId()).orElseThrow(()->new ExerciseNotFoundException());

        sessionExerciseId.setExerciseId(exercise.getId());
        sessionExerciseId.setSessionId(session.getId());

        sessionExercise.setSession(session);
        sessionExercise.setExercise(exercise);
        sessionExercise.setId(sessionExerciseId);

        /** TODO: 06.05.2020
         * private int reps;
         *     private int sets;
         *     private int orderNumber;
         *     private int time;
         *     private String tempo;
         *     private String description;
         *     brakuje
         *
          */

        return sessionExercise;

    }
}
