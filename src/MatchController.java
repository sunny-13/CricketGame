import java.util.Scanner;
import java.lang.Math;


public class MatchController {

    private int totalBallsEachInning;

    public Team team1;
    public Team team2;

    public MatchController(){
        System.out.println("Enter the number of overs for each inning !");
        Scanner scanner = new Scanner();
        int overs = scanner.nextInt();
        totalBallsEachInning = overs*6;
        team1 = new Team(1);
        team2 = new Team(2);

    }

    public void startMatch(){
        playInning1();
        playInning1();

        System.out.println("--------BOTH INNINGS FINISH----------");

        if(team1.getTotalRuns()>=team2.getTotalRuns()){
            System.out.println("TEAM1 IS WINNER");
        }
        else{
            System.out.println("TEAM2 IS WINNER");
        }


    }

    public void playInning1(){
        int currBalls=1;
        while(currBalls<=totalBallsEachInning && team1.getTotalWicketsDown()<10){

            ballDecision(team1,team2,currBalls);
            if(currBalls%6==0) {
                System.out.println("---------------");
                //swap(team1.strikePlayer,team1.nonStrikePlayer);
            }
            currBalls++;
        }
    }

    public void playInning2(){
        int currBalls=1;
        while(currBalls<=totalBallsEachInning && team2.getTotalWicketsDown()<10 && team2.getTotalRuns()<=team1.getTotalRuns()){

            ballDecision(team2,team1,currBalls);
            if(currBalls%6==0) {
                System.out.println("---------------");
                //swap(team1.strikePlayer,team1.nonStrikePlayer);
            }
            currBalls++;
        }
    }

    public int ballDecision(Team battingteam,Team bowlingTeam,int ball){
        int decision  = (int) (Math.random()*8);
        if(decision<=6){
            if(decision%2==1){
                //swap(team1.strikePlayer,team1.nonStrikePlayer);
            }
            System.out.println("Runs scored on "+ (ball/6)+1 + "over's " + (ball%6)+1 + "ball: "+ decision);
            battingteam.setTotalRuns(decision);
            battingteam.setTotalBallsBowled();
            battingteam.strikePlayer.setRunScored(decision);
            battingteam.strikePlayer.setBallsPlayed();
        }
        else{
            System.out.println("Wicket down on "+ (ball/6)+1 + "over's " + (ball%6)+1 + "ball ");
            battingteam.setTotalBallsPlayed();
            battingteam.strikePlayer.setBallsPlayed();
            battingteam.setTotalWicketsDown();
            battingteam.strikePlayer.setIsOut(true);
            for(int i=0;i<11;i++){
                if(!battingteam.teamPlayers.get(i).getIsOut()){
                    battingteam.strikePlayer = battingteam.teamPlayers.get(i);
                }
            }
        }
    }

}
