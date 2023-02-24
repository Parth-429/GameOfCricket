package com.cricketGame.models.beans;

import com.cricketGame.constants.Constants;
import com.cricketGame.services.generators.ObjectIDGenerator;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "over_of_innings")
public class Over extends Bean {
    private int overNo;
    @OneToMany(targetEntity = Ball.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "over_id", referencedColumnName = "id")
    private List<Ball> ballsOfOver = new ArrayList<>();
    public Over(){
        super(ObjectIDGenerator.getID());
        this.overNo = Constants.CURRENT_OVER_NO++;
        System.out.println(overNo);
    }
}
