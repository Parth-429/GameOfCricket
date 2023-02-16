package com.cricketGame.services.daoServices;

import com.cricketGame.models.player.Player;
import com.cricketGame.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public void savePlayer(Player player){
        this.playerRepository.save(player);
    }

}
