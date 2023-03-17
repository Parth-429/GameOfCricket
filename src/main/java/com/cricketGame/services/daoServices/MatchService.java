package com.cricketGame.services.daoServices;


import com.cricketGame.dto.MatchDTO;
import com.cricketGame.models.beans.Match;

import java.util.List;

public interface MatchService {
    void updateMatch(Match match);
    Match saveMatch(MatchDTO matchDTO);
    Match findMatchById(Long id);
    List<MatchDTO> findMatchPlayedByTeamById(Long id);
    String checkMatchIsPlayedOrNot(Long id);
    Match getScoreCard(Long matchId);
}
