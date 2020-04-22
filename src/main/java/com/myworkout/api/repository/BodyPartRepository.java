package com.myworkout.api.repository;

import com.myworkout.api.entity.BodyPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BodyPartRepository extends JpaRepository<BodyPart, Long> {



}
