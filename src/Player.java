public class Player {
    private String name;
    private int runScored;
    private int ballsPlayed;
    private int runGiven;
    private int ballsBowled;
    private int wicketsTaken;

    private boolean isRemaining;
    public Player(String name){
        this.name=name;
        this.isRemaining=true;
    }

    public String getName(){
        return this.name;
    }

    public int getRunScored(){
        return runScored;
    }

    public int getBallsPlayed() {
        return ballsPlayed;
    }

    public int getRunGiven() {
        return runGiven;
    }

    public int getBallsBowled() {
        return ballsBowled;
    }

    public int getWicketsTaken() {
        return wicketsTaken;
    }

    public boolean getIsRemaining(){
        return this.isRemaining;
    }

    public void setRunScored(int addRuns){
        this.runScored+=addRuns;
    }

    public void setBallsPlayed(){
        this.ballsPlayed+=1;
    }

    public void setRunGiven(int addRuns){
        this.runGiven+=addRuns;
    }

    public void setBallsBowled(){
        this.ballsBowled+=1;
    }

    public void setWicketsTaken(){
        this.wicketsTaken+=1;
    }

    public void setIsRemaining(boolean bool){
        this.isRemaining=bool;
    }
}
