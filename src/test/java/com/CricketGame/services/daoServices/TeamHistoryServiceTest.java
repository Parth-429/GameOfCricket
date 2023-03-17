package com.CricketGame.services.daoServices;
import com.CricketGame.utils.DtoUtils;
import com.CricketGame.utils.TeamHistoryUtils;
import com.cricketGame.dto.TeamDTO;
import com.cricketGame.mappers.TeamMapper;
import com.cricketGame.models.beans.team.TeamHistory;
import com.cricketGame.repository.TeamHistoryRepository;
import com.cricketGame.services.daoServicesImpl.TeamHistoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TeamHistoryServiceTest {
    @Mock
    private TeamHistoryRepository teamHistoryRepository;
    @Mock
    private TeamMapper teamMapper;
    @InjectMocks
    private TeamHistoryService teamHistoryService;

    @Test
    void saveTeam() {
        //given
        TeamDTO teamDTO = DtoUtils.getTeamDTO();
        TeamHistory teamHistory = TeamHistoryUtils.getTeamHistory("Parth");
        when(teamMapper.toTeam(any(TeamDTO.class))).thenReturn(teamHistory);
        when(teamHistoryRepository.save(any(TeamHistory.class))).thenReturn(teamHistory);
        //when
        TeamHistory actualTeamHistory = teamHistoryService.saveTeam(teamDTO);
        //Assertion
        assertEquals(teamHistory, actualTeamHistory);
    }

    @Test
    void findByTeamID_IfTeamExist(){
        TeamHistory teamHistory = TeamHistoryUtils.getTeamHistory("team");
        when(teamHistoryRepository.findById(anyLong())).thenReturn(Optional.ofNullable(teamHistory));

        TeamHistory actualTeamHistory = teamHistoryService.findTeamById(10L);

        assertEquals(teamHistory, actualTeamHistory);
    }

    @Test
    void findByTeamID_IfTeamNotExist(){
        when(teamHistoryRepository.findById(anyLong())).thenReturn(Optional.ofNullable(null));

        TeamHistory actualTeamHistory = teamHistoryService.findTeamById(10L);

        assertNull(actualTeamHistory);
    }
}