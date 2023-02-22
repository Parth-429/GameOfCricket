package com.cricketGame.repository;

import com.cricketGame.models.player.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    @Override
    Optional<Person> findById(Long id);
}
