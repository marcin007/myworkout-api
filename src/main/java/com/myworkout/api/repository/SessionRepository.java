package com.myworkout.api.repository;

import com.myworkout.api.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {

    List<Session> findAllByUser_Id(Long id);
    Optional<Session> findByIdAndUserId(Long sessionId, Long userId);

}
