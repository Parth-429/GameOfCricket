package com.cricketGame.repository;

import com.cricketGame.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface _TeamRepository extends JpaRepository<Team, Long> {
    @Override
    Optional<Team> findById(Long id);

}
