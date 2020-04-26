package com.myworkout.api.service;

import com.myworkout.api.entity.BodyPart;
import com.myworkout.api.exception.BodyPartNotFoundException;
import com.myworkout.api.repository.BodyPartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BodyPartService {

    private BodyPartRepository bodyPartRepository;

    @Autowired
    public BodyPartService(BodyPartRepository bodyPartRepository) {
        this.bodyPartRepository = bodyPartRepository;
    }

    public Page<BodyPart> findAll(Pageable pageable) {
        return bodyPartRepository.findAll(pageable);
    }

    public BodyPart findById(Long id) {
        return bodyPartRepository.findById(id)
                .orElseThrow(BodyPartNotFoundException::new);
    }


}
