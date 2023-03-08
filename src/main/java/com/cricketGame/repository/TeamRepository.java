package com.cricketGame.repository;

import com.cricketGame.models.beans.team.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Long> {
    @Override
    Optional<Team> findById(Long id);

    @Query(value = "select * from team where name=:t_name", nativeQuery = true)
    List<Team> findByName(@Param("t_name") String name);
}
