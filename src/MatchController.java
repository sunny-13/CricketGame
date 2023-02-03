import java.util.Collection;
import java.util.Scanner;
import java.lang.Math;


public class MatchController {

    private int totalBallsEachInning;
    public Team team1;
    public Team team2;



    //-------CONSTRUCTOR
    public MatchController(){
        System.out.println("Enter the number of overs for each inning !");
        Scanner scanner = new Scanner(System.in);
        int overs = scanner.nextInt();
        totalBallsEachInning = overs*6;
        team1 = new Team(1);
        team2 = new Team(2);

    }


    //-------START MATCH
    public void startMatch(){
        System.out.println("\n---------INNING1 START----------\n");
        playInning1();
        System.out.println("\n---------INNING1 FINISH----------\n");
        System.out.println("\n---------INNING2 START----------\n");
        playInning2();
        System.out.println("\n---------INNING2 FINISH----------\n");


        System.out.println("TEAM1 SCORE : " + team1.getTotalRuns() + "/" + team1.getTotalWicketsDown());
        System.out.println("TEAM2 SCORE : " + team2.getTotalRuns() + "/" + team1.getTotalWicketsDown());

        if(team1.getTotalRuns()>=team2.getTotalRuns()){
            System.out.println("TEAM1 IS WINNER");
        }
        else{
            System.out.println("TEAM2 IS WINNER");
        }

        team1.printScoreCard();
        team2.printScoreCard();


    }


    //-------BALL DECISION
    public void ballDecision(Team battingteam,Team bowlingTeam,int ball){
        int decision  = (int) (Math.random()*8);
        if(decision<=6){

            System.out.print(decision+" ");
            battingteam.setTotalRuns(decision);
            battingteam.setTotalBallsBowled();
            battingteam.strikePlayer.setRunScored(decision);
            battingteam.strikePlayer.setBallsPlayed();
            if(decision%2==1){
                changeStrike(battingteam);
            }
        }
        else{
            System.out.print("W ");
            battingteam.setTotalBallsPlayed();
            battingteam.strikePlayer.setBallsPlayed();
            battingteam.setTotalWicketsDown();
            for(int i=0;i<11;i++){
                if(battingteam.teamPlayers.get(i).getIsRemaining()){
                    battingteam.strikePlayer = battingteam.teamPlayers.get(i);
                    break;
                }
            }
        }
    }



    //--------CHANGE STRIKE
    public void changeStrike(Team battingTeam){
//        System.out.println("calling strike change\n");
        Player swapper = battingTeam.strikePlayer;
        battingTeam.strikePlayer = battingTeam.nonStrikePlayer;
        battingTeam.nonStrikePlayer = swapper;
    }



    //---------PLAY INNING 1
    public void playInning1(){
        int currBalls=1;
        while(currBalls<=totalBallsEachInning && team1.getTotalWicketsDown()<10){

            ballDecision(team1,team2,currBalls);
            if(currBalls%6==0) {
                System.out.println("\n");
                changeStrike(team1);
            }
            currBalls++;
        }
    }


    //----------PLAY INNING 2
    public void playInning2(){
        int currBalls=1;
        while(currBalls<=totalBallsEachInning && team2.getTotalWicketsDown()<10 && team2.getTotalRuns()<=team1.getTotalRuns()){

            ballDecision(team2,team1,currBalls);
            if(currBalls%6==0) {
                System.out.println("\n");
                    changeStrike(team2);
            }
            currBalls++;
        }
    }



}
