package com.cricketGame.repository;

import com.cricketGame.models.beans.team.TeamHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamHistoryRepository extends JpaRepository<TeamHistory, Long> {
    Optional<TeamHistory> findById(Long id);
}
