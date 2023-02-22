package com.cricketGame.repository;

import com.cricketGame.models._Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface _TeamRepository extends JpaRepository<_Team, Long> {
    @Override
    Optional<_Team> findById(Long id);

}
