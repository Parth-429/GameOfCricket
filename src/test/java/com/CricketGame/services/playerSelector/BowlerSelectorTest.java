package com.CricketGame.services.playerSelector;

import com.cricketGame.models.beans.player.Bowler;
import com.cricketGame.models.beans.player.Player;
import com.cricketGame.services.generators.RandomNumberGenerator;
import com.cricketGame.services.playerSelector.BowlerSelector;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class BowlerSelectorTest {

    @Test
    void bowlerSelector_WhenPrevBowlerIsNull_ReturnNewBowler(){

        //given
        Random rm = mock(RandomNumberGenerator.class);
        List<Player> players = new ArrayList<>();
        players.add(new Bowler());
        players.add(new Bowler());
        players.add(new Bowler());
        given(rm.nextInt()).willReturn(0);
        Player expectedPlayer = players.get(0);
        Player prevBowler = null;

        //when
        Player actualPlayer = BowlerSelector.selectBowler(prevBowler,players);

        //Assertions
        assertEquals(expectedPlayer,actualPlayer);
        assertEquals(3,players.size());
    }

    @Test
    void bowlerSelector_WhenPrevBowlerIsNotNull_ReturnNewBowler(){

        //given
        Random rm = mock(RandomNumberGenerator.class);
        List<Player> players = new ArrayList<>();
        players.add(new Bowler(1L,null,1));
        players.add(new Bowler(2L,null,2));
        players.add(new Bowler(3L,null,3));
        Player prevBowler = players.get(1);
        given(rm.nextInt(anyInt())).willReturn(0);
        Player expectedPlayer = players.get(0);

        //when
        Player actualPlayer = BowlerSelector.selectBowler(prevBowler,players);

        //Assertions
        assertNotSame(prevBowler,actualPlayer);
        assertEquals(expectedPlayer,actualPlayer);
        assertEquals(3,players.size());
    }
}