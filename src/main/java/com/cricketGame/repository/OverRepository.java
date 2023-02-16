package com.cricketGame.repository;

import com.cricketGame.models.innings.Over;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OverRepository extends JpaRepository<Over,Long> {

}
