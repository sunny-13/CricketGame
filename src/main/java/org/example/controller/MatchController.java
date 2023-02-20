package org.example.controller;
import org.example.classes.Match;
import org.example.classes.ScoreCard;

import java.util.Scanner;




//Making it Singleton
public class MatchController {
    private static Match match;
    private static MatchController singleInstance = null;

    public static MatchController getInstance() {
        if (singleInstance == null) {
            return singleInstance = new MatchController();

        }

        return singleInstance;
    }


    public static void getNewMatch() {
        System.out.println("Enter the type of match wanted: ODI / T20 ");
        Scanner scanner = new Scanner(System.in);
        String matchType = scanner.next();
        System.out.println("Enter the name of team1");
        String team1Name= scanner.next();
        System.out.println("Enter the name of team2");
        String team2Name = scanner.next();

        //WRITE A WAY TO GENERATE A MATCHID TOO FOR STORING THE MATCH
        match = new Match(matchType,team1Name,team2Name);
        toss();

    }

    public static void toss(){
        //select the battingteam and bowlingteam here.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter choice \"HEADS\" or \"TAILS\" :" );
        String tossChoice = scanner.next();
        int random = (int) (Math.random()*2)+1;
        if((tossChoice.equals("HEADS") && random ==1) || (tossChoice.equals("TAILS") && random==2)){
            match.setCurrentBatting(match.scoreCard[0]);
            match.setCurrentBowling(match.scoreCard[1]);
        }
        else{
            match.setCurrentBatting(match.scoreCard[1]);
            match.setCurrentBowling(match.scoreCard[0]);
        }
        startMatch();
    }

    private static void changeTeam(){
        ScoreCard temp = match.getCurrentBatting();
        match.setCurrentBatting(match.getCurrentBowling());
        match.setCurrentBowling(temp);
    }

    private static void startMatch() {

        System.out.println("----------------STARTING INNING1-------------");
        match.playInning1();
        //change bowling team to batting and viceVersa;
        changeTeam();
        System.out.println("----------------STARTING INNING2-------------");

        match.playInning2();
        match.declareResult();
    }


}
