package com.cricketGame.services.daoServices;

import com.cricketGame.models.innings.PartnerShip;
import com.cricketGame.repository.PartnerShipRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class PartnerShipService{

    @Autowired
    private PartnerShipRepository partnerShipRepository;
    public void savePartnerShip(PartnerShip partnerShip){
        this.partnerShipRepository.save(partnerShip);
    }

}
