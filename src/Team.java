

import java.util.ArrayList;
import java.util.List;

public class Team {
    public List<Player> teamPlayers;

    public Player strikePlayer;
    public Player nonStrikePlayer;
    private int totalRuns;
    private int totalBallsPlayed;
    private int totalWicketsDown;

    private int totalBallsBowled;
    private int totalWicketsTaken;
    private int totalRunsGiven;


    public Team(int teamNumber){
        teamPlayers = new ArrayList<>();
        for(int i=0;i<11;i++){
            String playerName = "team"+teamNumber+"player"+i;
            Player p = new Player(playerName);
            teamPlayers.add(p);

        }

        strikePlayer = teamPlayers.get(0);
        teamPlayers.get(0).setIsRemaining(false);
        nonStrikePlayer = teamPlayers.get(1);
        teamPlayers.get(1).setIsRemaining(false);

    }

    public int getTotalRuns() {
        return totalRuns;
    }

    public int getTotalBallsPlayed() {
        return totalBallsPlayed;
    }

    public int getTotalWicketsDown() {
        return totalWicketsDown;
    }

    public int getTotalBallsBowled() {
        return totalBallsBowled;
    }

    public int getTotalWicketsTaken() {
        return totalWicketsTaken;
    }

    public int getTotalRunsGiven() {
        return totalRunsGiven;
    }

    public void setTotalRuns(int addRuns) {
        this.totalRuns += addRuns;
    }

    public void setTotalBallsPlayed() {
        this.totalBallsPlayed +=1;
    }

    public void setTotalWicketsDown() {
        this.totalWicketsDown += 1;
    }

    public void setTotalRunsGiven(int addRuns) {
        this.totalRunsGiven += addRuns;
    }

    public void setTotalBallsBowled() {
        this.totalBallsBowled += 1;
    }

    public void setTotalWicketsTaken() {
        this.totalWicketsTaken += 1;
    }

    public void printScoreCard(){
        for(int i=0;i<11;i++){
            System.out.println(this.teamPlayers.get(i).getName()+ " "
                              + this.teamPlayers.get(i).getRunScored() + "/"
                              + this.teamPlayers.get(i).getBallsPlayed());
        }
    }


}
