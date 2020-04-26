package com.myworkout.api.controller;


import com.myworkout.api.entity.LevelOfAdvancement;
import com.myworkout.api.service.LevelOfAdvancementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LevelOfAdvancementController {

    private LevelOfAdvancementService levelOfAdvancementService;

    @Autowired
    public LevelOfAdvancementController(LevelOfAdvancementService levelOfAdvancementService) {
        this.levelOfAdvancementService = levelOfAdvancementService;
    }
}
