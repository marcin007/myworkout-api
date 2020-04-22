package com.myworkout.api.repository;

import com.myworkout.api.entity.ExercisePhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExercisePhotoRepository extends JpaRepository<ExercisePhoto, Long> {
}
