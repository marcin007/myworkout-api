package com.myworkout.api.controller;

import com.myworkout.api.ApiInfo;
import com.myworkout.api.dto.PatchSessionExerciseDTO;
import com.myworkout.api.dto.SessionExerciseDTO;
import com.myworkout.api.entity.SessionExerciseId;
import com.myworkout.api.mapper.SessionExerciseMapper;
import com.myworkout.api.service.SessionExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/sessions/{id}/exercises") //OK
    public List<SessionExerciseDTO> getExercisesBySessionId(@PathVariable Long id){
        return sessionExerciseMapper.toDto(sessionExerciseService.getExercisesBySessionId(id));
    }

    @PostMapping("/sessions/{id}/exercises") //ok
    public SessionExerciseDTO postSessionExercise(@PathVariable Long id, @RequestBody SessionExerciseDTO sessionExerciseDTO){
        return sessionExerciseMapper.toDto(sessionExerciseService.postSessionExercise(id, sessionExerciseMapper.toEntity(sessionExerciseDTO)));
    }

    @DeleteMapping("/sessions/{sessionId}/exercises/{exerciseId}") //ok (chce żeby sie usuwalo wszyko(cała sesje) ale bez kaskadowego usuwania cwiczenia w exercises)
    public ResponseEntity<ApiInfo> deleteSessionExerciseById(@PathVariable Long sessionId, @PathVariable Long exerciseId){
        sessionExerciseService.deleteById(sessionId, exerciseId);
        return new ResponseEntity<>(new ApiInfo("deleted session exercise", HttpStatus.OK.value()), HttpStatus.OK);
    }


    @PatchMapping("/sessions/{sessionId}/exercises/{exerciseId}") //ok
    public SessionExerciseDTO updateSessionExercise(@PathVariable Long sessionId, @PathVariable Long exerciseId, @RequestBody PatchSessionExerciseDTO sessionExerciseDTO){
        return sessionExerciseMapper.toDto(sessionExerciseService.updateSessionExercise(new SessionExerciseId(sessionId, exerciseId), sessionExerciseDTO));
    }



}
