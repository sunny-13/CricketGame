package org.example.classes;

import org.example.interfaces.BallDecision;
import org.example.service.BallDecisionODI;
import org.example.service.BallDecisionT20;

import java.util.Collections;
import java.util.List;
import java.util.UUID;


public class Match {

    public String matchID;
    public String matchType;
    public BallDecision ballDecision;
    private int totalBallsEachInning;



    public ScoreCard[] scoreCard;
    private ScoreCard currentBatting;  //Just a pointer
    private ScoreCard currentBowling;  //Just a pointer






    public Match(String matchType,String team1Name, String team2Name){
        //self generating matchID
        matchID = UUID.randomUUID().toString();
        this.matchType = matchType;
        if(matchType.equals("ODI")){

            totalBallsEachInning=300;
            ballDecision = new BallDecisionODI();
        }
        else{
            totalBallsEachInning=120;
            ballDecision = new BallDecisionT20();
        }
        //getTeam1Id + getTeam2Id
        String team1Id="I",team2id="P";
        System.out.println("Point1");
        scoreCard = new ScoreCard[2];
        scoreCard[0] = new ScoreCard(matchID,team1Id);
        scoreCard[1] = new ScoreCard(matchID,team2id);
        System.out.println(scoreCard[0].getMatchId());
        System.out.println(scoreCard[1].getMatchId());

    }

    public String getMatchID() {
        return matchID;
    }

    public String getMatchType() {
        return matchType;
    }


    public ScoreCard getCurrentBatting() {
        return currentBatting;
    }

    public void setCurrentBatting(ScoreCard currentBatting) {
        this.currentBatting = currentBatting;
    }

    public ScoreCard getCurrentBowling() {
        return currentBowling;
    }

    public void setCurrentBowling(ScoreCard currentBowling) {
        this.currentBowling = currentBowling;
    }

    public void changeStrike(){
        int temp = currentBatting.getStrikePlayer();
        currentBatting.setStrikePlayer(currentBatting.getNonStrikePlayer());
        currentBatting.setNonStrikePlayer(temp);
    }
    public void runScored(int run){
        System.out.print(run + " ");
        int strike = currentBatting.getStrikePlayer();
        currentBatting.getRunScored().set(strike,currentBatting.getRunScored().get(strike)+run);
        currentBatting.setTotalRuns(run);
        if(run%2==1) changeStrike();
    }

    public void wicketDown(){
        currentBatting.setWicketsDown(currentBatting.getWicketsDown()+1);
        List<Boolean> list = currentBatting.getPlayerOut();
        list.set(currentBatting.getStrikePlayer(),true);
        System.out.print("W ");

        for(int i=0;i<=10;i++){
            if(list.get(i)==false){

                currentBatting.setStrikePlayer(i);
                list.set(i,true);
                break;
            }
        }
    }


    public void overFinished(){
        System.out.println("\n");
        changeStrike();
    }




    public void playInning1(){
        int currBalls = 1;
        while (currBalls <= totalBallsEachInning && currentBatting.getWicketsDown() < 10) {
            int ballResult = ballDecision.ballDecision(currentBatting.getStrikePlayer());
            if(ballResult==7) wicketDown();
            else runScored(ballResult);

            if (currBalls % 6 == 0) {
                overFinished();
            }
            currBalls++;
        }
    }
    public void playInning2(){
        int currBalls = 1;
        while (currBalls <= totalBallsEachInning && currentBatting.getWicketsDown() < 10 && currentBatting.getTotalRuns() <= currentBowling.getTotalRuns()) {

            int ballResult = ballDecision.ballDecision(currentBatting.getStrikePlayer());
            if(ballResult==7) wicketDown();
            else runScored(ballResult);

            if (currBalls % 6 == 0) {
                overFinished();
            }
            currBalls++;
        }
    }

    public void declareResult(){
        System.out.println("");
        String team1Name = scoreCard[0].printScoreCard();
        String team2Name = scoreCard[1].printScoreCard();

        if(scoreCard[0].getTotalRuns()>scoreCard[1].getTotalRuns()) {
            scoreCard[0].setWin(true);
            System.out.println("---");
        }
        else if(scoreCard[0].getTotalRuns()<scoreCard[1].getTotalRuns()) {
            scoreCard[1].setWin(true);
            System.out.println("----");
        }
        else System.out.println("The match is TIE");

    }




}
