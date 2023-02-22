package com.cricketGame.services.daoServices;

import com.cricketGame.dto.MatchDTO;
import com.cricketGame.dtoMappers.MatchMapper;
import com.cricketGame.models.Match;
import com.cricketGame.repository.MatchRepository;
import com.cricketGame.services.gameStarter.MatchStarter;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        Optional<Match> checkMatch = this.matchRepository.findById(id);
        try {
            if (!checkMatch.isPresent())
                throw new IllegalArgumentException("Error : Match with given id is not exist");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return checkMatch.get();
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
        return  MatchStarter.startGame(id);
    }
}
