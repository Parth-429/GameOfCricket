package com.cricketGame.services.daoServices;

import com.cricketGame.models.innings.Ball;
import com.cricketGame.models.innings.Innings;
import com.cricketGame.repository.BallRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class BallService {
    @Autowired
    private BallRepository ballRepository;
    public void saveBall(Ball ball){
        this.ballRepository.save(ball);
    }

}
