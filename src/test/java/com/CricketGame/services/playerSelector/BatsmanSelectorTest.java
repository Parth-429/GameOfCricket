package com.CricketGame.services.playerSelector;

import com.CricketGame.utils.PlayerUtils;
import com.cricketGame.models.beans.player.Player;
import com.cricketGame.services.playerSelector.BatsmanSelector;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BatsmanSelectorTest {
    private final static int TEAM_SIZE = 5;

    @Test
    public void batsmanSelector_IfPlayersAreAvailable(){
        List<Player> players = PlayerUtils.getPlayerList(TEAM_SIZE);

        Player player = BatsmanSelector.selectBatsman(players);

        assertEquals(TEAM_SIZE-1, players.size());
        assertEquals(player, players.get(0));
    }

    @Test
    public void batsmanSelector_IfAllPlayersAreOut(){
        Player player = BatsmanSelector.selectBatsman(Collections.emptyList());

        assertNull(player);
    }
}