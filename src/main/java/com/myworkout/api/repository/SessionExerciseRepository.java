package com.myworkout.api.repository;

import com.myworkout.api.entity.Exercise;
import com.myworkout.api.entity.SessionExercise;
import com.myworkout.api.entity.SessionExerciseId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionExerciseRepository extends JpaRepository<SessionExercise, SessionExerciseId> {
    List<SessionExercise> findAllBySession_Id(Long id);
}
