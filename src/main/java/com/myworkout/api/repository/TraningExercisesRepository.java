package com.myworkout.api.repository;


import com.myworkout.api.entity.TraningExercises;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraningExercisesRepository extends JpaRepository<TraningExercises, Long> {
}
