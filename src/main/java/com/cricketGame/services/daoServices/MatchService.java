package com.cricketGame.services.daoServices;

import com.cricketGame.models.Match;
import com.cricketGame.repository.MatchRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    public void saveMatch(Match match){
        this.matchRepository.save(match);
    }
}
