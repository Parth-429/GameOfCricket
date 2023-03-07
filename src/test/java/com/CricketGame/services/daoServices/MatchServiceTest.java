package com.CricketGame.services.daoServices;

import com.cricketGame.dto.MatchDTO;
import com.cricketGame.mappers.MatchMapper;
import com.cricketGame.models.beans.Match;
import com.cricketGame.repository.MatchRepository;
import com.cricketGame.services.daoServices.MatchService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MatchServiceTest {

    @Mock
    MatchRepository matchRepository;
    @Spy
    MatchMapper matchMapper;
    @InjectMocks
    MatchService  matchService;
    @Captor
    ArgumentCaptor<Match> match;

    @Test
    void saveMatch() {
        //given
        MatchDTO matchDTO = new MatchDTO();
        //when
        matchService.saveMatch(matchDTO);
        //Assertion
        verify(matchRepository).save(match.capture());
    }

    @Test
    void updateMatch() {
    }

    @Test
    void findMatchById() {
    }

    @Test
    void checkMatchIsPlayedOrNot() {
    }

    @Test
    void getMatchRepository() {
    }

    @Test
    void getMatchMapper() {
    }

    @Test
    void setMatchRepository() {
    }

    @Test
    void setMatchMapper() {
    }
}