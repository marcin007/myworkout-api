package com.myworkout.api.repository;

import com.myworkout.api.entity.Traning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraningRepository extends JpaRepository<Traning, Long> {
}
