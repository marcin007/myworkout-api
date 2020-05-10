package com.myworkout.api.service;

import com.myworkout.api.dto.PatchSessionExerciseDTO;
import com.myworkout.api.entity.Session;
import com.myworkout.api.entity.SessionExercise;
import com.myworkout.api.entity.SessionExerciseId;
import com.myworkout.api.exception.SessionExerciseNotFoundException;
import com.myworkout.api.repository.SessionExerciseRepository;
import com.myworkout.api.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionExerciseService {

    private SessionRepository sessionRepository;
    private SessionExerciseRepository sessionExerciseRepository;

    @Autowired
    public SessionExerciseService(SessionRepository sessionRepository, SessionExerciseRepository sessionExerciseRepository) {
        this.sessionRepository = sessionRepository;
        this.sessionExerciseRepository = sessionExerciseRepository;
    }

    public List<SessionExercise> findAllById(Long id) {
        return sessionExerciseRepository.findAllBySessionId(id);
    }

    public SessionExercise postSessionExercise(Long sessionId, SessionExercise se) {
//        Session session = sessionRepository.findById(sessionId).orElseThrow();
//        session.getSessionExercises().add(se);
//        sessionRepository.save(session);
//        return se;

        return sessionExerciseRepository.save(se);
    }

    public void deleteById(Long sessionId, Long exerciseId) {
        sessionExerciseRepository.deleteById(new SessionExerciseId(sessionId, exerciseId));
    }

    public List<SessionExercise> getExercisesBySessionId(Long id) {
        return sessionExerciseRepository.findAllBySessionId(id);
    }

    public SessionExercise updateSessionExercise(SessionExerciseId sessionExerciseId, PatchSessionExerciseDTO sessionExerciseDTO) {
        SessionExercise sessionExercise = sessionExerciseRepository.findById(sessionExerciseId).orElseThrow(() -> new SessionExerciseNotFoundException());

        if (sessionExerciseDTO.getDescription() != null) {
            sessionExercise.setDescription(sessionExerciseDTO.getDescription());
        }

        if(sessionExerciseDTO.getReps() != null){
            sessionExercise.setReps(sessionExerciseDTO.getReps());
        }

        if(sessionExerciseDTO.getSets() != null){
            sessionExercise.setSets(sessionExerciseDTO.getSets());
        }

        return sessionExerciseRepository.save(sessionExercise);
    }



}
