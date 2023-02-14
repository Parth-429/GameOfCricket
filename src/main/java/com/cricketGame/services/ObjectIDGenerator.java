package com.cricketGame.services;

public class ObjectIDGenerator {
    public static long id=0;
    public static long getID(){
        return ++id;
    }
}
