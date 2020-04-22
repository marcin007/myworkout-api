package com.myworkout.api.repository;

import com.myworkout.api.entity.SessionExercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionExerciseRepository extends JpaRepository<SessionExercise, Long> {
}
