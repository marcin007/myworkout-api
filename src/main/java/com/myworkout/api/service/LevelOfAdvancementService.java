package com.myworkout.api.service;

import com.myworkout.api.entity.LevelOfAdvancement;
import com.myworkout.api.repository.LevelOfAdvancementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LevelOfAdvancementService {

    private LevelOfAdvancementRepository levelOfAdvancementRepository;

    @Autowired
    public LevelOfAdvancementService(LevelOfAdvancementRepository levelOfAdvancementRepository) {
        this.levelOfAdvancementRepository = levelOfAdvancementRepository;
    }
}
