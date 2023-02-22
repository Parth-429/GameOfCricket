package com.cricketGame.repository;

import com.cricketGame.models.TeamHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamRepository extends JpaRepository<TeamHistory, Long> {
    Optional<TeamHistory> findById(Long id);
}
