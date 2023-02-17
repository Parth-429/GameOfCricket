package com.cricketGame.controller;

import com.cricketGame.services.gameStarter.MatchStarter;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/startMatch")
public class LaunchGameController {

    @GetMapping("/{id}")
    public void launchGame(@PathVariable Long id){
        MatchStarter.startGame(id);
    }
}
