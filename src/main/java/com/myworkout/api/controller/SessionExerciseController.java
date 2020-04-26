package com.myworkout.api.controller;

import com.myworkout.api.entity.SessionExercise;
import com.myworkout.api.service.SessionExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionExerciseController {


    private SessionExerciseService sessionExerciseService;

    @Autowired
    public SessionExerciseController(SessionExerciseService sessionExerciseService) {
        this.sessionExerciseService = sessionExerciseService;
    }
}
