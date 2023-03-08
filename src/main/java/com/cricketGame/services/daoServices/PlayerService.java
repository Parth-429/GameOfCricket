package com.cricketGame.services.daoServices;

import com.cricketGame.dto.PlayerDTO;
import com.cricketGame.mappers.PlayerMapper;
import com.cricketGame.models.beans.player.Player;
import com.cricketGame.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public List<PlayerDTO> findPlayerByPerson(Long personId){
        List<PlayerDTO> playerDTOS = new ArrayList<>();
        for(Player player: playerRepository.findByPersonID(personId)){
            playerDTOS.add(playerMapper.toPlayerDto(player));
        }
        return playerDTOS;
    }
}
