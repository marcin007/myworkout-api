package com.myworkout.api.controller;

import com.myworkout.api.ApiInfo;
import com.myworkout.api.dto.PatchSessionDTO;
import com.myworkout.api.dto.SessionDTO;
import com.myworkout.api.dto.SessionDetailsDTO;
import com.myworkout.api.mapper.SessionMapper;
import com.myworkout.api.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class SessionController {

    private SessionService sessionService;
    private SessionMapper sessionMapper;

    @Autowired
    public SessionController(SessionService sessionService, SessionMapper sessionMapper) {
        this.sessionService = sessionService;
        this.sessionMapper = sessionMapper;
    }

    @GetMapping("/sessions")
    public List<SessionDTO> getAllSessions() {
        return sessionMapper.toSessionDTO(sessionService.findAll());
    }


    @GetMapping("/users/{userId}/sessions{sessionId}")
    public SessionDTO getUserSessionById(@PathVariable Long userId, @PathVariable Long sessionId){
        return sessionMapper.toSessionDTO(sessionService.getUserSessionById(sessionId, userId));
    }


    @GetMapping("/sessions/{id}")
    public SessionDetailsDTO getSessionDetailsById(@PathVariable Long id) {
        return sessionMapper.toSessionDetailsDto(sessionService.findById(id));
    }

    @PostMapping("/sessions")
    public SessionDTO postSession(@RequestBody SessionDTO sessionDTO) {
        return sessionMapper.toSessionDTO(sessionService.postSession(sessionMapper.toSessionEntity(sessionDTO)));
    }

    @DeleteMapping("/sessions/{id}")
    public ResponseEntity<ApiInfo> deleteSessionById(@PathVariable Long id) {
        sessionService.deleteSessionById(id);
        return new ResponseEntity<>(new ApiInfo("Deleted session", HttpStatus.OK.value()), HttpStatus.OK);
    }//Chce usunac sesje tak aby tez sie usunela w Session Exercises dlatego dodaje atrybut CascadeType.REMOVE

    @PatchMapping("/sessions/{id}")
    public SessionDTO updateSession(@PathVariable Long id, @Valid @RequestBody PatchSessionDTO patchSessionDTO) {
        return sessionMapper.toSessionDTO(sessionService.updateSession(id, patchSessionDTO));
    }


}
