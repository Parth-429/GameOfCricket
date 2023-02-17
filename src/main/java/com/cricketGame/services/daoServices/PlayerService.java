package com.cricketGame.services.daoServices;

import com.cricketGame.constants.Constants;
import com.cricketGame.dto.PlayerDTO;
import com.cricketGame.dtoMappers.PlayerMapper;
import com.cricketGame.models.player.Batsman;
import com.cricketGame.models.player.Bowler;
import com.cricketGame.models.player.Player;
import com.cricketGame.repository.PlayerRepository;
import com.cricketGame.services.generators.ObjectIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private PlayerMapper playerMapper;

    public Player savePlayer(PlayerDTO playerDTO){
        Player player = playerMapper.toPlayer(playerDTO);
        return this.playerRepository.save(player);
    }

    public Player findPlayerById(Long id){
        return this.playerRepository.findById(id).get();
    }
}
