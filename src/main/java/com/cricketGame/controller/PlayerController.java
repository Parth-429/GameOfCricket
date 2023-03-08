package com.cricketGame.controller;

import com.cricketGame.dto.PlayerDTO;
import com.cricketGame.mappers.PlayerMapper;
import com.cricketGame.models.beans.player.Player;
import com.cricketGame.services.daoServices.PlayerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {
    @Autowired
    public PlayerService playerService;
    @Autowired
    public PlayerMapper playerMapper;
    @PostMapping("/")
    public ResponseEntity<PlayerDTO> addPlayer(@Valid @RequestBody PlayerDTO playerDTO){
        Player player = playerService.savePlayer(playerDTO);
        return ResponseEntity.ok(playerMapper.toPlayerDto(player));
    }

    @GetMapping("/person/{person_id}/")
    public ResponseEntity<List<PlayerDTO>> findPlayerByPersonId(@PathVariable(name = "person_id") Long personId){
        return ResponseEntity.ok(playerService.findPlayerByPerson(personId));
    }
}
