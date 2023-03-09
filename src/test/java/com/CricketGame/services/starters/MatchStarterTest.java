package com.CricketGame.services.starters;

import com.CricketGame.utils.MatchUtils;
import com.cricketGame.models.beans.Innings;
import com.cricketGame.models.beans.Match;
import com.cricketGame.models.beans.team.TeamHistory;
import com.cricketGame.models.enums.Coin;
import com.cricketGame.services.generators.CoinTosser;
import com.cricketGame.services.starters.InningStarter;
import com.cricketGame.services.starters.MatchStarter;
import com.cricketGame.view.ScoreCard;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MatchStarterTest {

    @Mock
    private CoinTosser coinTosser;
    @Mock
    private InningStarter inningStarter;
    @InjectMocks
    private MatchStarter matchStarter;
    @Mock
    private ScoreCard scoreCard;
    @Test
    public void startMatch(){
        Match match = MatchUtils.getMatch("TeamX", "TeamY");
        when(inningStarter.playInning(any(TeamHistory.class), any(TeamHistory.class), any(Innings.class),
                anyBoolean())).thenReturn(100,102);
        when(scoreCard.showScoreCard(any(Match.class))).thenReturn("ScoreCard Returned");
        when(coinTosser.tossCoin()).thenReturn(Coin.HEAD);

        String result = matchStarter.startGame(match);

        assertNotNull(result);
        assertEquals(2,match.getInnings().size());
        assertEquals(match.getInnings().get(0).getBattingTeam(), match.getTeam1());
        assertEquals(match.getInnings().get(0).getBowlingTeam(), match.getTeam2());
        assertEquals(match.getInnings().get(1).getBattingTeam(), match.getTeam2());
        assertEquals(match.getInnings().get(1).getBowlingTeam(), match.getTeam1());
    }
}