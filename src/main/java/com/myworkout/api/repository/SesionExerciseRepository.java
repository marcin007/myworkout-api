package com.myworkout.api.repository;

import com.myworkout.api.entity.SesionExercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SesionExerciseRepository extends JpaRepository<SesionExercise, Long> {
}
