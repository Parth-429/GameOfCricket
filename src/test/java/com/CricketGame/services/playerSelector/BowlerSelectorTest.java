package com.CricketGame.services.playerSelector;
import com.CricketGame.utils.PlayerUtils;
import com.cricketGame.models.beans.player.Player;
import com.cricketGame.services.generators.RandomNumberGenerator;
import com.cricketGame.services.playerSelector.BowlerSelector;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.internal.matchers.Null;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BowlerSelectorTest {
    @InjectMocks
    private BowlerSelector bowlerSelector;
    private final static int TEAM_SIZE = 5;

    @Test
    public void BowlerSelector_WhenPrevBowlerIsNull(){
        List<Player> players = PlayerUtils.getPlayerList(TEAM_SIZE);
        Player expectedBowler = players.get(0);

        Player actualPlayer = bowlerSelector.selectBowler(null, players);

        assertEquals(expectedBowler, actualPlayer);
    }

    @Test
    public void BowlerSelector_WhenPrevBowlerIsNotNull(){
        List<Player> players = PlayerUtils.getPlayerList(TEAM_SIZE);
        Player prevBowler = players.get(1);

        Player actualPlayer = bowlerSelector.selectBowler(prevBowler, players);

        assertNotEquals(prevBowler.getId(), actualPlayer.getId());
    }
}