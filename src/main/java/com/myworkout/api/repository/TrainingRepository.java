package com.myworkout.api.repository;

import com.myworkout.api.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {

    List<Training> findAllByHasExpiredFalse();

    Optional<Training> findByIdAndHasExpiredFalse(Long id);
}
