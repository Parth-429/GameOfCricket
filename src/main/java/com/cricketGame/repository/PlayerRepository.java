package com.cricketGame.repository;
import com.cricketGame.dto.PlayerDTO;
import com.cricketGame.models.beans.player.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    Optional<Player> findById(Long id);

    @Query(value = "select * from player where person_id=:p_id", nativeQuery = true)
    List<Player> findByPersonID(@Param("p_id") Long personID);
}
