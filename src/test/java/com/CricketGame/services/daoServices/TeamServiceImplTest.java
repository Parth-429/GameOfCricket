package com.CricketGame.services.daoServices;

import com.CricketGame.utils.TeamUtils;
import com.cricketGame.models.beans.team.Team;
import com.cricketGame.repository.TeamRepository;
import com.cricketGame.services.daoServicesImpl.TeamServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class TeamServiceImplTest {

    @InjectMocks
    private TeamServiceImpl teamService;
    @Mock
    private TeamRepository teamRepository;
    @Captor
    private ArgumentCaptor<Team> teamArgumentCaptor;
    @Test
    public void addTeam(){
        Team team = TeamUtils.getTeam("teamX");
        when(teamRepository.save(any())).thenReturn(team);

        Team actualTeam = teamService.addTeam("teamX");

        verify(teamRepository).save(teamArgumentCaptor.capture());
        assertEquals(actualTeam.getName(), teamArgumentCaptor.getValue().getName());
        assertEquals(team, actualTeam);
    }

    @Test
    public void findTeamById_WhenTeamExist(){
        Team team = TeamUtils.getTeam("teamx");
        when(teamRepository.findById(anyLong())).thenReturn(Optional.ofNullable(team));

        Team actualteam = teamService.findTeamById(10L);

        assertEquals(team, actualteam);
    }

    @Test
    public void findTeamById_WhenTeamNotExist(){
        when(teamRepository.findById(anyLong())).thenReturn(Optional.ofNullable(null));

        Team actualteam = teamService.findTeamById(10L);

        assertNull(actualteam);
    }

    @Test
    public void findTeamByName_WhenTeamExist(){
        List<Team> teams = TeamUtils.getListOfTeams();
        when(teamRepository.findByName("teamX")).thenReturn(teams);

        List<Team> actualTeams = teamService.findTeamByName("teamX");

        assertEquals(teams, actualTeams);
    }

    @Test
    public void findTeamByName_WhenTeamNotExist(){

        when(teamRepository.findByName("teamX")).thenReturn(Collections.emptyList());

        List<Team> actualTeams = teamService.findTeamByName("teamX");

        assertTrue(actualTeams.isEmpty());
    }
}