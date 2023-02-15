package com.cricketGame.constants;

public class Constants {

    public static String BATTING_ROLE = "Batsman";
    public static String BOWLING_ROLE = "Bowler";
    public static int OVERS_FOR_T20 = 20;
    public static int OVERS_FOR_ODI = 50;
    public static int OVERS_FOR_TEST = 90;
    public static int BALL_START = 1;
    public static int CURRENT_OVER_NO=0;
    public static int CURRENT_BALL_NO = 0;
    public static int CURRENT_WICKET_NO=0;
    public static int ALLOWED_TEAM_SIZE = 11;
    public static int MAX_BALLS_IN_ONE_OVER = 6;
    public static void resetCurrentOverNo(){
        CURRENT_OVER_NO = 0;
    }
    public static void resetWicketNo(){
        CURRENT_WICKET_NO = 0;
    }
    public static void resetBallNo(){
        CURRENT_BALL_NO = 0;
    }
}
