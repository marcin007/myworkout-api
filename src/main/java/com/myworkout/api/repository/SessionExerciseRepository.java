package com.myworkout.api.repository;

import com.myworkout.api.entity.Exercise;
import com.myworkout.api.entity.SessionExercise;
import com.myworkout.api.entity.SessionExerciseId;
import org.hibernate.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SessionExerciseRepository extends JpaRepository<SessionExercise, SessionExerciseId> {

    List<SessionExercise> findAllBySessionId(Long id);
    List<SessionExercise> findAllBySession_Id(Long id);
    void deleteSessionExerciseBySessionId(Long id);
    void deleteSessionExerciseByExerciseId(Long id);
    void deleteSessionExercisesBySessionId(Long id);
    List<SessionExercise> findAllExercisesBySessionId(Long id);
}
