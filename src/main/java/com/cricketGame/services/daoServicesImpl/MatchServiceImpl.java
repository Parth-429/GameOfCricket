package com.cricketGame.services.daoServicesImpl;

import com.cricketGame.dto.MatchDTO;
import com.cricketGame.mappers.MatchMapper;
import com.cricketGame.models.beans.Match;
import com.cricketGame.repository.MatchRepository;
import com.cricketGame.services.starters.MatchStarter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MatchServiceImpl implements com.cricketGame.services.daoServices.MatchService {
    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private MatchMapper matchMapper;
    public Match saveMatch(MatchDTO matchDTO){
        Match match = matchMapper.toMatch(matchDTO);
        return this.matchRepository.save(match);
    }
    public void updateMatch(Match match){
        this.matchRepository.save(match);
    }
    public Match findMatchById(Long id){
        Optional<Match> checkMatch = this.matchRepository.findById(id);
        return checkMatch.orElse(null);
    }

    public List<MatchDTO> findMatchPlayedByTeamById(Long id){
        List<MatchDTO> matches =new ArrayList<>();
        for(Match match: matchRepository.findMatchByTeamID(id)){
            matches.add(matchMapper.toMatchDto(match));
        }
        return matches;
    }

    public String checkMatchIsPlayedOrNot(Long id){
        Match match = findMatchById(id);
        try{
            if(match.getInnings().size()!=0) throw new IllegalArgumentException("Error: Match with given id is " +
                                                                                "already played, please create new " +
                                                                                "match to start");
        }catch(Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
        String result  = MatchStarter.startGame(match);
        updateMatch(match);
        return result;
    }

    public Match getScoreCard(Long matchId) {
        return findMatchById(matchId);
    }
}
