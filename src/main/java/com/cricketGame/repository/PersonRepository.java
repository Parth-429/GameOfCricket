package com.cricketGame.repository;

import com.cricketGame.models.beans.player.Person;
import com.cricketGame.models.beans.player.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    @Override
    Optional<Person> findById(Long id);

    @Query(value = "select * from person where first_name=:fname and last_name=:lname", nativeQuery = true)
    List<Person> findByFirstNameAndLastName(@Param("fname") String firstName, @Param("lname") String lastName);
}
