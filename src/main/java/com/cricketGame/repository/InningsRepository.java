package com.cricketGame.repository;

import com.cricketGame.models.innings.Innings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InningsRepository extends JpaRepository<Innings,Long> {

}
