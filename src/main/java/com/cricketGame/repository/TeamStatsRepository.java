package com.cricketGame.repository;

import com.cricketGame.models.stats.TeamStats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamStatsRepository extends JpaRepository<TeamStats, Long> {

}
