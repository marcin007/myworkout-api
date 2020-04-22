package com.myworkout.api.repository;


import com.myworkout.api.entity.TrainingExercises;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingExercisesRepository extends JpaRepository<TrainingExercises, Long> {
}
