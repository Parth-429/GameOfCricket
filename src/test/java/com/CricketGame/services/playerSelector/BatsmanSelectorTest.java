package com.CricketGame.services.playerSelector;


import com.cricketGame.models.beans.player.Batsman;
import com.cricketGame.models.beans.player.Bowler;
import com.cricketGame.models.beans.player.Player;
import com.cricketGame.services.generators.RandomNumberGenerator;
import com.cricketGame.services.playerSelector.BatsmanSelector;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BatsmanSelectorTest {

    @Mock
    RandomNumberGenerator randomNumberGenerator;
    @Test
    void batsmanSelector_WhenListIsNotEmpty_ReturnBatsman(){

        //given
        List<Player> players = new ArrayList<>();
        players.add(new Batsman());
        players.add(new Bowler());
        players.add(new Batsman());
        Player expectedPlayer = players.get(0);
        //when
        Player actualPlayer = BatsmanSelector.selectBatsman(players);

        //Assertions
        assertEquals(expectedPlayer,actualPlayer);
        assertEquals(2,players.size());
    }

    @Test
    void batsmanSelector_WhenListIsEmpty_ReturnNull(){
        //given
        List<Player> players = new ArrayList<>();
        //when
        Player actualPlayer = BatsmanSelector.selectBatsman(players);
        //Assertions
        assertNull(actualPlayer);
    }
}