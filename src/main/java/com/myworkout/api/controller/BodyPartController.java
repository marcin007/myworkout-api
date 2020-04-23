package com.myworkout.api.controller;


import com.myworkout.api.PageableDefaults;
import com.myworkout.api.entity.BodyPart;
import com.myworkout.api.service.BodyPartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BodyPartController {

    private BodyPartService bodyPartService;

    @Autowired
    public BodyPartController(BodyPartService bodyPartService) {
        this.bodyPartService = bodyPartService;
    }

    @GetMapping("/bodyParts")
    public List<BodyPart> getAll(@PageableDefaults(minSize = 50, maxSize = 50, size = 50) Pageable pageable) {
        return bodyPartService.findAll(pageable).getContent();
    }


}
