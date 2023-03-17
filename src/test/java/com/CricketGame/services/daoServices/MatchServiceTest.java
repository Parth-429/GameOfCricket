package com.CricketGame.services.daoServices;

import com.CricketGame.utils.DtoUtils;
import com.CricketGame.utils.InningsUtils;
import com.CricketGame.utils.MatchUtils;
import com.cricketGame.dto.MatchDTO;
import com.cricketGame.mappers.MatchMapper;
import com.cricketGame.models.beans.Match;
import com.cricketGame.repository.MatchRepository;
import com.cricketGame.services.daoServicesImpl.MatchService;
import com.cricketGame.services.starters.MatchStarter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

class MatchServiceTest {
    @Mock
    private MatchRepository matchRepository;
    @Mock
    private MatchMapper matchMapper;
    @InjectMocks
    private MatchService matchService;
    @Mock
    private MatchStarter matchStarter;

    @Test
    public void saveMatch(){
        //given
        MatchDTO matchDTO = DtoUtils.getMatchDTO();
        Match expectedMatch = MatchUtils.getMatch("TeamX", "TeamY");
        when(matchMapper.toMatch(matchDTO)).thenReturn(expectedMatch);
        when(matchRepository.save(expectedMatch)).thenReturn(expectedMatch);

        //when
        Match actualMatch = matchService.saveMatch(matchDTO);

        //assertions
        verify(matchMapper, times(1)).toMatch(matchDTO);
        verify(matchRepository, times(1)).save(expectedMatch);
        assertEquals(expectedMatch, actualMatch);
    }

    @Test
    public void findMatchById_WhenIDIsValid(){

        //given
        Match expectedMatch = MatchUtils.getMatch("TeamX", "TeamY");
        when(matchRepository.findById(anyLong())).thenReturn(Optional.ofNullable(expectedMatch));

        //when
        Match actuaMatch = matchService.findMatchById(10L);

        //assertions
        verify(matchRepository, times(1)).findById(10L);
        assertEquals(actuaMatch,expectedMatch);
    }

    @Test
    public void findMatchById_WhenIDIsNotValid(){
        //given
        Match expectedMatch = null;
        when(matchRepository.findById(anyLong())).thenReturn(Optional.ofNullable(expectedMatch));

        //when
        Match actuaMatch = matchService.findMatchById(10L);

        //assertions
        verify(matchRepository, times(1)).findById(10L);
        assertEquals(actuaMatch,actuaMatch);
    }

    @Test
    public void checkMatchIsPlayedOrNot_IfMatchISValid() {
        //given
        Match match = MatchUtils.getMatch("TeamX", "TeamY");
        String expectedResult = "Successfully Played Match";
        when(matchRepository.findById(anyLong())).thenReturn(Optional.of(match));
        when(matchStarter.startGame(any(Match.class))).thenReturn(expectedResult);

        //when
        String actualResult = matchService.checkMatchIsPlayedOrNot(10L);

        //assertions
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void checkMatchIsPlayedOrNot_IfMatchIsNotValid() {
        //given
        Match match = MatchUtils.getMatch("TeamX", "TeamY");
        match.addNewInnings(InningsUtils.getInnings());
        String expectedResult = "Error: Match with given id is " + "already played, please create new " + "match to start";
        when(matchRepository.findById(anyLong())).thenReturn(Optional.of(match));
        //when
        String actualResult = matchService.checkMatchIsPlayedOrNot(10L);
        //assertions
        verify(matchStarter, times(0)).startGame(any(Match.class));
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void findMatchPlayedByTeamById() {
        List<Match> matches = MatchUtils.getMatchList();
        List<MatchDTO> expectedResult = DtoUtils.getMatchList();
        MatchDTO matchDTO1 = expectedResult.get(0);
        MatchDTO matchDTO2 = expectedResult.get(1);
        when(matchRepository.findMatchByTeamID(anyLong())).thenReturn(matches);
        when(matchMapper.toMatchDto(any(Match.class))).thenReturn(matchDTO1, matchDTO2);

        List<MatchDTO> actualResult = matchService.findMatchPlayedByTeamById(10L);

        assertEquals(expectedResult, actualResult);
    }
}