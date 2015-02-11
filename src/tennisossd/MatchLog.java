package tennisossd;

import java.util.ArrayList;

public class MatchLog {

    ArrayList<MatchScore> matches = new ArrayList<>();

    public void addMatchToLog(MatchScore match) {
        matches.add(match);
    }

    public ArrayList<MatchScore> getMatch(String homeT, String awayT) {
        ArrayList<MatchScore> possibleMatches = new ArrayList<>();
        for (MatchScore m : matches) {
            
            if (m.getHomeTeamName().equalsIgnoreCase(homeT) && m.
                    getAwayTeamName().equalsIgnoreCase(awayT)) {
                possibleMatches.add(m);
            }
        }
        
        if (possibleMatches.isEmpty()) {
            return null;
        }
        return possibleMatches;
        
/*
        int index = matches.indexOf(new MatchScore(homeT, awayT, null, null,
                null, null));

        if (index > -1) {
            return matches.get(index);
        }
        return null;*/
    }
}
