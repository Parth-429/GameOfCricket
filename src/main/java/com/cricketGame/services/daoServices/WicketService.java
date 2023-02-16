package com.cricketGame.services.daoServices;

import com.cricketGame.models.innings.Wicket;
import com.cricketGame.repository.WicketRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class WicketService {

    @Autowired
    private WicketRepository wicketRepository;

    public void saveWicket(Wicket wicket){
        this.wicketRepository.save(wicket);
    }
}
