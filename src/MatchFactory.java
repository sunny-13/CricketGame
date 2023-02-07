public class MatchFactory {
    public static IMatch getANewMatch(String matchType){
        if(matchType.equals("ODI")){
            return new ODIMatch();
        }
        else if(matchType.equals("T20")){
            return new T20Match();
        }

        //handle wrong matchType
        return null;
    }
}
