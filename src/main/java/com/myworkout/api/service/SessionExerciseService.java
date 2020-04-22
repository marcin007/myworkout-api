package com.myworkout.api.service;

import com.myworkout.api.repository.SessionExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionExerciseService {


    private SessionExerciseRepository sessionExerciseRepository;

    @Autowired
    public SessionExerciseService(SessionExerciseRepository sessionExerciseRepository) {
        this.sessionExerciseRepository = sessionExerciseRepository;
    }
}
