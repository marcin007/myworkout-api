package com.myworkout.api.repository;

import com.myworkout.api.entity.LevelOfAdvancement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelOfAdvancementRepository extends JpaRepository<LevelOfAdvancement, Long> {
}
