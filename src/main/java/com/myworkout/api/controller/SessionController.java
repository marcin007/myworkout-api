package com.myworkout.api.controller;

import com.myworkout.api.ApiInfo;
import com.myworkout.api.dto.PatchSessionDTO;
import com.myworkout.api.dto.SessionDTO;
import com.myworkout.api.entity.Session;
import com.myworkout.api.mapper.SessionMapper;
import com.myworkout.api.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@Controller
public class SessionController {

    private SessionService sessionService;
    private SessionMapper sessionMapper;

    @Autowired
    public SessionController(SessionService sessionService, SessionMapper sessionMapper) {
        this.sessionService = sessionService;
        this.sessionMapper = sessionMapper;
    }

// /users/id/sessions?last=1
//    @GetMapping("/users/{id}/sessions")
//    public List<Session> getSessions(@PathVariable Long id, @RequestParam Long last) {
//
//    }

    @GetMapping("/users/{id}/sessions")
    public List<SessionDTO> getSessionsByUsersId(@PathVariable Long id){
        return sessionMapper.toSessionDTO(sessionService.getSessionsByUsersId(id));
    }

   @PostMapping("/users/sessions")
    public SessionDTO postSession(@RequestBody SessionDTO sessionDTO){
        return sessionMapper.toSessionDTO(sessionService.postSession(sessionMapper.toSessionEntity(sessionDTO)));
   }

   @DeleteMapping("/users/sessions/{id}")
    public ApiInfo deleteSessionById(@PathVariable Long id){
        sessionService.deleteSessionById(id);
        return new ApiInfo("Deleted session", HttpStatus.OK.value());
   }

   @PatchMapping("/users/sessions/{id}")
    public SessionDTO updateSession(@PathVariable Long id, @Valid @RequestBody PatchSessionDTO patchSessionDTO){
        return sessionMapper.toSessionDTO(sessionService.updateSession(id,patchSessionDTO));
   }



}
