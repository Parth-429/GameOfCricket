package com.cricketGame.services.daoServices;
import com.cricketGame.models.innings.Ball;
import com.cricketGame.models.innings.Innings;
import com.cricketGame.models.innings.Over;
import com.cricketGame.models.innings.Wicket;
import com.cricketGame.repository.InningsRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Data
@Service
public class InningsService {
    @Autowired
    private InningsRepository inningsRepository;

    public void saveInnings(Innings innings){
        this.inningsRepository.save(innings);
    }

    public void saveOversAndWickets(Innings innings){

        for(Wicket wicket: innings.getWickets()){
            AllService.wicketService.saveWicket(wicket);
        }

        for(Over over: innings.getOvers()) {
            for(Ball ball: over.getBallsOfOver())
                AllService.ballService.saveBall(ball);
            AllService.overService.saveOver(over);
        }
    }
}
