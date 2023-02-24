package com.cricketGame.controller;

import com.cricketGame.dto.PlayerDTO;
import com.cricketGame.mappers.PlayerMapper;
import com.cricketGame.models.beans.player.Player;
import com.cricketGame.services.daoServices.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/player")
public class PlayerController {
    @Autowired
    public PlayerService playerService;
    @Autowired
    public PlayerMapper playerMapper;
    @PostMapping("/")
    public PlayerDTO addPlayer(@RequestBody PlayerDTO playerDTO){
        Player player = playerService.savePlayer(playerDTO);
        return playerMapper.toPlayerDto(player);
    }
}
