package com.cricketGame.repository;

import com.cricketGame.models.stats.BatsmanStats;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BatsmanStatsRepository extends JpaRepository<BatsmanStats,Long> {

}
