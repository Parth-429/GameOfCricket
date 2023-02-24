package com.cricketGame.repository;

import com.cricketGame.models.beans.Match;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MatchRepository extends JpaRepository<Match, Long> {
    public Optional<Match> findById(Long id);
}
