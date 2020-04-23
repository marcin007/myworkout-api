package com.myworkout.api.controller;

import com.myworkout.api.entity.Session;
import com.myworkout.api.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SessionController {

    private SessionService sessionService;

    @Autowired
    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    // /users/id/sessions?last=1
//    @GetMapping("/users/{id}/sessions")
//    public List<Session> getSessions(@PathVariable Long id, @RequestParam Long last) {
//
//    }


}
