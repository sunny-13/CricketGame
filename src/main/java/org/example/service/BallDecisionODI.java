package org.example.service;

import org.example.interfaces.BallDecision;

public class BallDecisionODI implements BallDecision {

    public int ballDecisionBatsman(){

        int random = (int) (Math.random()*100)+1;
        if(random<90) return random%7;
        return 7;
    }



    public int ballDecisionBowler(){
        int random = (int) (Math.random()*100)+1;
        if(random<85) return random%7;
        return 7;
    }


}
