public class T20Match implements IMatch{

    private final int totalBallsEachInning=120;
    private Team team1,team2;
    public T20Match(){
        System.out.println("T20 match created");
        team1 = new Team(1);
        team2 = new Team(2);
    }
    public void playInning1(){
        int currBalls = 1;
        while (currBalls <= totalBallsEachInning && team1.getTotalWicketsDown() < 10) {

            ballDecision(team1, team2);
            if (currBalls % 6 == 0) {
                System.out.println("\n");
                changeStrike(team1);
            }
            currBalls++;
        }
    }
    public void playInning2(){
        int currBalls = 1;
        while (currBalls <= totalBallsEachInning && team2.getTotalWicketsDown() < 10 && team2.getTotalRuns() <= team1.getTotalRuns()) {

            ballDecision(team2, team1);
            if (currBalls % 6 == 0) {
                System.out.println("\n");
                changeStrike(team2);
            }
            currBalls++;
        }
    }

    public Team getTeam1(){
        return team1;
    }

    public Team getTeam2(){
        return team2;
    }
}
