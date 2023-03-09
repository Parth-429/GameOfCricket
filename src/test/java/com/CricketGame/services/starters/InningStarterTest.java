package com.CricketGame.services.starters;

import com.CricketGame.utils.InningsUtils;
import com.CricketGame.utils.TeamHistoryUtils;
import com.cricketGame.models.beans.Innings;
import com.cricketGame.models.beans.player.Bowler;
import com.cricketGame.models.beans.player.Player;
import com.cricketGame.models.beans.team.TeamHistory;
import com.cricketGame.models.enums.PlayerBattingStatus;
import com.cricketGame.models.enums.Role;
import com.cricketGame.models.enums.Runs;
import com.cricketGame.models.stats.BatsmanStats;
import com.cricketGame.models.stats.BowlerStats;
import com.cricketGame.models.stats.TeamStats;
import com.cricketGame.services.generators.RunGenerator;
import com.cricketGame.services.playerSelector.BatsmanSelector;
import com.cricketGame.services.playerSelector.BowlerSelector;
import com.cricketGame.services.starters.InningStarter;
import com.cricketGame.view.showStats.BattingStats;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class InningStarterTest {

    @Mock
    private BatsmanSelector batsmanSelector;
    @Mock
    private BowlerSelector bowlerSelector;
    @Mock
    private RunGenerator runGenerator;
    @InjectMocks
    private InningStarter inningStarter;
    private Innings firstInning;

    @Test
    public void playInning_FirstInning() {
        Innings innings = InningsUtils.getInnings();
        TeamHistory battingTeam = innings.getBattingTeam();
        TeamHistory bowlingTeam = innings.getBowlingTeam();

        when(runGenerator.generateRun(any(Role.class))).thenReturn(Runs.ONE);
        when(batsmanSelector.selectBatsman(any(ArrayList.class))).thenReturn(battingTeam.getPlayers().get(0),
                battingTeam.getPlayers().get(1));
        when(bowlerSelector.selectBowler(any(), any(ArrayList.class))).thenReturn(bowlingTeam.getPlayers().get(0));

        int firstInningScore = inningStarter.playInning(battingTeam, bowlingTeam, innings, false);

        assertEquals(20, innings.getOvers().size());
        assertEquals(0, innings.getWickets().size());

        assertEquals(60, ((BatsmanStats) (battingTeam.getPlayers().get(0).getBatsmanStats())).getRunsScoredByBatsman());
        assertEquals(60, ((BatsmanStats) (battingTeam.getPlayers().get(1).getBatsmanStats())).getRunsScoredByBatsman());
        assertEquals(60, ((BatsmanStats) (battingTeam.getPlayers().get(0).getBatsmanStats())).getBallPlayedByBatsman());
        assertEquals(60, ((BatsmanStats) (battingTeam.getPlayers().get(1).getBatsmanStats())).getBallPlayedByBatsman());
        assertEquals(PlayerBattingStatus.NOT_OUT,
                ((BatsmanStats) (battingTeam.getPlayers().get(0).getBatsmanStats())).getBattingStatus());
        assertEquals(PlayerBattingStatus.NOT_OUT, ((BatsmanStats) (battingTeam.getPlayers().get(1).getBatsmanStats())).getBattingStatus());
        assertEquals(120, ((BowlerStats) (bowlingTeam.getPlayers().get(0).getBowlerStats())).getNoOfBallsThrown());
        assertEquals(0, ((BowlerStats) (bowlingTeam.getPlayers().get(0).getBowlerStats())).getTotalWicketsTaken());
        assertEquals(120, ((BowlerStats) (bowlingTeam.getPlayers().get(0).getBowlerStats())).getTotalRunGiven());
        assertEquals(firstInningScore, ((TeamStats) battingTeam.getTeamStats()).getTotalScore());
        assertEquals(0, ((TeamStats) battingTeam.getTeamStats()).getTotalWickets());
        assertEquals("20.0", ((TeamStats) battingTeam.getTeamStats()).getOvers());
        this.firstInning = innings;
    }

    @Test
    public void playInning_SecondInning() {
        playInning_FirstInning();
        Innings firstInnings = this.firstInning;
        Innings secondInnings = InningsUtils.getInnings();
        secondInnings.setBattingTeam(firstInnings.getBowlingTeam());
        secondInnings.setBowlingTeam(firstInnings.getBattingTeam());

        TeamHistory battingTeam = secondInnings.getBattingTeam();
        TeamHistory bowlingTeam = secondInnings.getBowlingTeam();

        when(runGenerator.generateRun(any(Role.class))).thenReturn(Runs.THREE);
        when(batsmanSelector.selectBatsman(any(ArrayList.class))).thenReturn(battingTeam.getPlayers().get(0),
                battingTeam.getPlayers().get(1));
        when(bowlerSelector.selectBowler(any(), any(ArrayList.class))).thenReturn(bowlingTeam.getPlayers().get(0));

        int secondInningScore = inningStarter.playInning(battingTeam, bowlingTeam, secondInnings, true);

        assertEquals(20, secondInnings.getOvers().size());
        assertEquals(0, secondInnings.getWickets().size());

        assertEquals(63, ((BatsmanStats) (battingTeam.getPlayers().get(0).getBatsmanStats())).getRunsScoredByBatsman());
        assertEquals(60, ((BatsmanStats) (battingTeam.getPlayers().get(1).getBatsmanStats())).getRunsScoredByBatsman());
        assertEquals(21, ((BatsmanStats) (battingTeam.getPlayers().get(0).getBatsmanStats())).getBallPlayedByBatsman());
        assertEquals(20, ((BatsmanStats) (battingTeam.getPlayers().get(1).getBatsmanStats())).getBallPlayedByBatsman());
        assertEquals(PlayerBattingStatus.NOT_OUT,
                ((BatsmanStats) (battingTeam.getPlayers().get(0).getBatsmanStats())).getBattingStatus());
        assertEquals(PlayerBattingStatus.NOT_OUT, ((BatsmanStats) (battingTeam.getPlayers().get(1).getBatsmanStats())).getBattingStatus());
        assertEquals(41, ((BowlerStats) (bowlingTeam.getPlayers().get(0).getBowlerStats())).getNoOfBallsThrown());
        assertEquals(0, ((BowlerStats) (bowlingTeam.getPlayers().get(0).getBowlerStats())).getTotalWicketsTaken());
        assertEquals(123, ((BowlerStats) (bowlingTeam.getPlayers().get(0).getBowlerStats())).getTotalRunGiven());
        assertEquals(secondInningScore, ((TeamStats) battingTeam.getTeamStats()).getTotalScore());
        assertEquals(0, ((TeamStats) battingTeam.getTeamStats()).getTotalWickets());
        assertEquals("6.5", ((TeamStats) battingTeam.getTeamStats()).getOvers());
    }
}