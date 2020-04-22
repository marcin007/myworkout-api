package com.myworkout.api.service;

import com.myworkout.api.repository.BodyPartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BodyPartService {

    private BodyPartRepository bodyPartRepository;

    @Autowired
    public BodyPartService(BodyPartRepository bodyPartRepository) {
        this.bodyPartRepository = bodyPartRepository;
    }



}
