package com.myworkout.api.repository;

import com.myworkout.api.entity.TraningType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraningTypeRepository extends JpaRepository<TraningType, Long> {
}
