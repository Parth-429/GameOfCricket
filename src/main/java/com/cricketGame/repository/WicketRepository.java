package com.cricketGame.repository;

import com.cricketGame.models.innings.Wicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WicketRepository extends JpaRepository<Wicket, Long> {

}
