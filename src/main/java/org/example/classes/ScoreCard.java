package org.example.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ScoreCard {
    private String _id;

    private String teamId;
    private String matchId;

    private int wicketsDown;

    private int totalRuns;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    private int strikePlayer;
    private int nonStrikePlayer;

    private List<Boolean> playerOut;

    private List<Integer> runScored;
    private boolean win;



    public int getStrikePlayer() {
        return strikePlayer;
    }

    public void setStrikePlayer(int strikePlayer) {
        this.strikePlayer = strikePlayer;
    }

    public int getNonStrikePlayer() {
        return nonStrikePlayer;
    }

    public void setNonStrikePlayer(int nonStrikePlayer) {
        this.nonStrikePlayer = nonStrikePlayer;
    }





    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public int getWicketsDown() {
        return wicketsDown;
    }

    public void setWicketsDown(int wicketsDown) {
        this.wicketsDown = wicketsDown;
    }

    public List<Integer> getRunScored() {
        return runScored;
    }


    public List<Boolean> getPlayerOut() {
        return playerOut;
    }

    public int getTotalRuns() {
        return totalRuns;
    }

    public void setTotalRuns(int run) {
        this.totalRuns += run;
    }


    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public ScoreCard(String matchId, String teamId){
        this._id = UUID.randomUUID().toString();
        this.teamId = teamId;
        this.matchId = matchId;
        wicketsDown=0;
        strikePlayer = 0;
        nonStrikePlayer = 1;
        runScored = new ArrayList<Integer>();
        while(runScored.size()<11) runScored.add(0);
        playerOut = new ArrayList<Boolean>();
        while(playerOut.size()<11) playerOut.add(false);
    }

    public ScoreCard(){ }

    public String printScoreCard(){
        //Team name printOut
        //get the name of the player by dao
        System.out.println("");
        for(int i=0;i<11;i++){

            System.out.println(runScored.get(i));
        }
        return "Team's name that you have retrieved";
    }




}
