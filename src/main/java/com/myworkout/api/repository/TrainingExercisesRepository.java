package com.myworkout.api.repository;


import com.myworkout.api.entity.TrainingExerciseId;
import com.myworkout.api.entity.TrainingExercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingExercisesRepository extends JpaRepository<TrainingExercise, TrainingExerciseId> {

    List<TrainingExercise> findAllByTrainingId(Long id);
    TrainingExercise findByTrainingId(Long id);
}
