package com.cricketGame.repository;

import com.cricketGame.models.beans.team.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Long> {
    @Override
    Optional<Team> findById(Long id);

}
