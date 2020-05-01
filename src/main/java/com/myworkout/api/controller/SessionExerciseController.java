package com.myworkout.api.controller;

import com.myworkout.api.dto.SessionExerciseDTO;
import com.myworkout.api.entity.SessionExercise;
import com.myworkout.api.mapper.SessionExerciseMapper;
import com.myworkout.api.service.SessionExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SessionExerciseController {

    private SessionExerciseService sessionExerciseService;
    private SessionExerciseMapper sessionExerciseMapper;

    @Autowired
    public SessionExerciseController(SessionExerciseService sessionExerciseService, SessionExerciseMapper sessionExerciseMapper) {
        this.sessionExerciseService = sessionExerciseService;
        this.sessionExerciseMapper = sessionExerciseMapper;
    }

    @GetMapping("/sessionExercises")
    List<SessionExerciseDTO> getAllSessionExercises() {
        return sessionExerciseMapper.toDto(sessionExerciseService.findAll());

    }
}
