import java.lang.Math;
public interface IMatch {

    default void ballDecision(Team battingteam, Team bowlingTeam){
        int decision = (int) (Math.random() * 8);
        if (decision <= 6) {
            runScored(battingteam,bowlingTeam,decision);
        } else {
            wicketDown(battingteam);
            getNextBatsman(battingteam);
        }
    }

    default void runScored(Team battingteam, Team bowlingTeam,int run){
        System.out.print(run + " ");
        battingteam.setTotalRuns(run);
        battingteam.setTotalBallsBowled();
        battingteam.strikePlayer.setRunScored(run);
        battingteam.strikePlayer.setBallsPlayed();
        if (run % 2 == 1) {
            changeStrike(battingteam);
        }
    }

    default void wicketDown(Team battingteam){
        System.out.print("W ");
        battingteam.setTotalBallsPlayed();
        battingteam.strikePlayer.setBallsPlayed();
        battingteam.setTotalWicketsDown();
    }

    default void getNextBatsman(Team battingteam){
        for (int i = 0; i < 11; i++) {
            if (battingteam.teamPlayers.get(i).getIsRemaining()) {
                battingteam.strikePlayer = battingteam.teamPlayers.get(i);
                break;
            }
        }
    }


    default void changeStrike(Team battingTeam){
        Player swapper = battingTeam.strikePlayer;
        battingTeam.strikePlayer = battingTeam.nonStrikePlayer;
        battingTeam.nonStrikePlayer = swapper;
    }

    default void declareResult(Team team1,Team team2){
        team1.printScoreCard();
        team2.printScoreCard();
    }

    Team getTeam1();
    Team getTeam2();
    void playInning1();
    void playInning2();
}
