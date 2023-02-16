package com.cricketGame.repository;

import com.cricketGame.models.stats.BowlerStats;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BowlingStatsRepository extends JpaRepository<BowlerStats, Long> {
}
