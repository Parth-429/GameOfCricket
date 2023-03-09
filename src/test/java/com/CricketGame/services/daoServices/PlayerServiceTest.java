package com.CricketGame.services.daoServices;

import com.CricketGame.utils.DtoUtils;
import com.CricketGame.utils.PlayerUtils;
import com.cricketGame.dto.PlayerDTO;
import com.cricketGame.mappers.PlayerMapper;
import com.cricketGame.models.beans.player.Player;
import com.cricketGame.models.enums.Role;
import com.cricketGame.repository.PlayerRepository;
import com.cricketGame.services.daoServices.PlayerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PlayerServiceTest {
    @Mock
    private PlayerRepository playerRepository;
    @Mock
    private PlayerMapper playerMapper;
    @InjectMocks
    private PlayerService playerService;

    @Test
    public void savePlayer(){
        PlayerDTO playerDTO = DtoUtils.getPlayerDTO(Role.BOWLER, 1);
        Player player = PlayerUtils.getBowler(1);
        when(playerMapper.toPlayer(any(PlayerDTO.class))).thenReturn(player);
        when(playerRepository.save(any(Player.class))).thenReturn(player);

        Player actualPlayer = playerService.savePlayer(playerDTO);

        assertEquals(player, actualPlayer);
    }

    @Test
    void findPlayerByPerson_WhenPersonExist(){
        List<PlayerDTO> playerDTOList = DtoUtils.getListOfPlayerDTOs(2);
        List<Player> players = PlayerUtils.getPlayerList(2);
        when(playerRepository.findByPersonID(anyLong())).thenReturn(players);
        when(playerMapper.toPlayerDto(any(Player.class))).thenReturn(playerDTOList.get(0), playerDTOList.get(1));

        List<PlayerDTO> actualPlayerDTOList = playerService.findPlayerByPerson(10L);

        assertEquals(playerDTOList, actualPlayerDTOList);
    }

    @Test
    void findPlayerByPerson_WhenPersonNotExist(){

        when(playerRepository.findByPersonID(anyLong())).thenReturn(Collections.emptyList());

        List<PlayerDTO> actualPlayerDTOList = playerService.findPlayerByPerson(10L);

        verify(playerMapper, times(0)).toPlayerDto(any(Player.class));
        assertTrue(actualPlayerDTOList.isEmpty());
    }
}