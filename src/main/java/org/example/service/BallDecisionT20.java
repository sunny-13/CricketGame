package org.example.service;

import org.example.interfaces.BallDecision;

public class BallDecisionT20 implements BallDecision {

    public int ballDecisionBatsman(){
        //The probability of runs is 90% .
        //The probability of being out is 30%.
        int random = (int) (Math.random()*100)+1;
        if(random<85) return random%7;
        return 7;
    }



    public int ballDecisionBowler(){
        int random = (int) (Math.random()*100)+1;
        if(random<70) return random%7;
        return 7;
    }
}
