package com.cricketGame.services.daoServices;

import com.cricketGame.dto.PlayerDTO;
import com.cricketGame.models.beans.player.Player;

import java.util.List;

public interface PlayerService {
    Player savePlayer(PlayerDTO playerDTO);
    List<PlayerDTO> findPlayerByPerson(Long personId);
}
