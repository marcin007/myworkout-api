package com.myworkout.api.service;

import com.myworkout.api.entity.SessionExercise;
import com.myworkout.api.repository.SessionExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionExerciseService {


    private SessionExerciseRepository sessionExerciseRepository;

    @Autowired
    public SessionExerciseService(SessionExerciseRepository sessionExerciseRepository) {
        this.sessionExerciseRepository = sessionExerciseRepository;
    }

    public List<SessionExercise> findAll() {
        return sessionExerciseRepository.findAll();
    }
}
