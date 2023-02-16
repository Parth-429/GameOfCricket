package com.cricketGame.models.innings;

import com.cricketGame.constants.Constants;
import com.cricketGame.models.Bean;
import com.cricketGame.services.generators.ObjectIDGenerator;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.aop.scope.ScopedProxyUtils;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "over_of_innings")
public class Over extends Bean {
    private int overNo;
    @Transient
    private List<Ball> ballsOfOver = new ArrayList<>();
    public Over(){
        super(ObjectIDGenerator.getID());
        this.overNo = Constants.CURRENT_OVER_NO++;
        System.out.println(overNo);
    }
    public int getTotalRunScoredInOver(){
        int totalRunScoredInOver = 0;
        for(Ball ball: ballsOfOver){
            totalRunScoredInOver += ball.getRunMade().getRun();
        }
        return totalRunScoredInOver;
    }
}
