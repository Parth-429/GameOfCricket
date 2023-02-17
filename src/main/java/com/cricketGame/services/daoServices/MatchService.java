package com.cricketGame.services.daoServices;

import com.cricketGame.dto.MatchDTO;
import com.cricketGame.dtoMappers.MatchMapper;
import com.cricketGame.models.Match;
import com.cricketGame.models.Team;
import com.cricketGame.repository.MatchRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class MatchService {

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
        return this.matchRepository.findById(id).get();
    }
}
