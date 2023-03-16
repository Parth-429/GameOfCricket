package com.cricketGame.services.generators;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ObjectIDGenerator {
    public static long id=0;
    public static long getID(){
        return ++id;
    }
}
