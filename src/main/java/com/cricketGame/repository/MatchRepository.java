package com.cricketGame.repository;

import com.cricketGame.models.beans.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MatchRepository extends JpaRepository<Match, Long> {
    Optional<Match> findById(Long id);

    @Query(value = "select * from match_of_cricket where team1_id=:id or team2_id=:id", nativeQuery = true)
    List<Match> findMatchByTeamID(@Param("id") Long id);
}
