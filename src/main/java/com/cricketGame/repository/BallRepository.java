package com.cricketGame.repository;

import com.cricketGame.models.innings.Ball;
import com.cricketGame.models.innings.Innings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BallRepository extends JpaRepository<Ball,Long> {

}
