package com.cricketGame.models.beans.team;

import com.cricketGame.models.beans.Bean;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper=false)
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})})
public class Team extends Bean {
    @Column(name = "name")
    private String name;
    public Team(Long id, String name){
        super(id);
        this.name = name;
    }
}
