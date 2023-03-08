package com.CricketGame.services.daoServices;

import com.CricketGame.utils.Utils;
import com.cricketGame.dto.MatchDTO;
import com.cricketGame.mappers.MatchMapper;
import com.cricketGame.models.beans.Match;
import com.cricketGame.repository.MatchRepository;
import com.cricketGame.services.daoServices.MatchService;
import com.cricketGame.services.starters.MatchStarter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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
    private MatchService  matchService;

    @Test
    public void saveMatch(){
        //given
        MatchDTO matchDTO = Utils.getMatchDTO();
        Match expectedMatch = Utils.getMatch("TeamX", "TeamY");
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
        Match expectedMatch = Utils.getMatch("TeamX", "TeamY");
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

}