package com.myworkout.api.repository;

import com.myworkout.api.entity.ApiKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApiKeysRepository extends JpaRepository<ApiKey, Long> {

    Optional<ApiKey> findByValue(String value);
}
