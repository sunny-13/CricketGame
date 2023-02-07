import java.util.Scanner;




//Making it Singleton
public class MatchController {
    private static IMatch match;
    private static MatchController singleInstance = null;

    public static MatchController getInstance() {
        if (singleInstance == null) {
            return singleInstance = new MatchController();

        }

        return singleInstance;
    }


    public static void getNewMatch() {
        System.out.println("Enter the type of match wanted: ODI / T20 ");
        Scanner scanner = new Scanner(System.in);
        String matchType = scanner.next();
        match = MatchFactory.getANewMatch(matchType);
        startMatch();
    }

    private static void startMatch() {

        System.out.println("----------------STARTING INNING1-------------");
        match.playInning1();
        System.out.println("----------------STARTING INNING2-------------");
        match.playInning2();
        match.declareResult(match.getTeam1(), match.getTeam2());
    }


}
