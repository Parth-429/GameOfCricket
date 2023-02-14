package com.cricketGame.services.generators;

public class ObjectIDGenerator {
    public static long id=0;
    public static long getID(){
        return ++id;
    }
}
