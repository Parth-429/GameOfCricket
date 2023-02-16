package com.cricketGame.services.daoServices;

import com.cricketGame.models.innings.Over;
import com.cricketGame.repository.OverRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class OverService {

    @Autowired
    private OverRepository overRepository;
    public void saveOver(Over over){
        this.overRepository.save(over);
    }
}
