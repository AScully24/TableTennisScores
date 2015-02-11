package tennisossd;

public class MatchScore {

    public static int TEAMSIZE;

    Team homeTeam, awayTeam;
    SetScore[] sets = new SetScore[5];
    int homeTeamWin, awayTeamWin;

    /**
     *
     * @param homeTeam
     * @param awayTeam
     * @param homeP1
     * @param homeP2
     * @param awayP1
     * @param awayP2
     */
    public MatchScore(Team homeTeam, Team awayTeam, Player homeP1,
            Player homeP2, Player awayP1, Player awayP2) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;

        int setNum = 0;
        sets[0] = new SingleSet(setNum++, homeP1, awayP1);
        sets[1] = new SingleSet(setNum++, homeP1, awayP2);
        sets[2] = new SingleSet(setNum++, homeP2, awayP1);
        sets[3] = new SingleSet(setNum++, homeP2, awayP2);
        sets[4] = new DoubleSet(setNum++, homeP1, awayP1, homeP2, awayP2);

    }

    // Returns a single set based upon the two players involved in the set.
    public SingleSet getASingleSet(String hName, String aName) {
        for (int i = 0; i < sets.length - 1; i++) {
            SetScore setScore = sets[i];
            if (setScore.getHomePlayer1().getName().equals(hName)
                    && setScore.getAwayPlayer1().getName().equals(aName)) {
                return (SingleSet) setScore;
            }
        }
        return null;
    }

    // Gets the double set, which is alway the last one in the array.
    public DoubleSet getDoubleSet() {
        return (DoubleSet) sets[4];
    }

    // Returns the total wins a home player has had in the the Match
    public int getHomePWin() {
        int winCount = 0;

        for (SetScore s : sets) {
            if (s.getHomeWins() > s.getAwayWins()) {
                winCount++;
            }
        }
        return winCount;
    }

    // Returns the total home team win count.
    public int getHomeTWin() {
        return homeTeamWin;
    }

    // Returns the total away team win count.
    public int getAwayTWin() {
        return awayTeamWin;
    }

    // Returns the total wins for an individual player.
    public int calculateHomePlayerScore(String hName) {
        int homePlayerScore = 0;

        for (int i = 0; i < sets.length - 1; i++) {
            SingleSet singleSet = (SingleSet) sets[i];
            if (singleSet.getHomePlayer1().getName().equals(hName)) {
                if (singleSet.getHomeWins() > singleSet.getAwayWins()) {
                    homePlayerScore++;
                }
            }
        }

        if (sets[4].getHomeWins() > sets[4].getAwayWins()) {
            homePlayerScore++;
        }
        return homePlayerScore;
    }

    // Sets the values for the win scores for each team.
    public void calculateHomeTeamScore() {
        for (SetScore s : sets) {
            s.calculateHomeWin();
        }

        homeTeamWin = getHomePWin();
        awayTeamWin = 5 - homeTeamWin;
    }

    // Return a string containing the home teams name
    public String getHomeTeamName() {
        return homeTeam.getName();
    }

    // Return a string containing the away teams name
    public String getAwayTeamName() {
        return awayTeam.getName();
    }

    // Finalises and save the data to the system.
    public void submitTeamAndPlayerWins() {
        homeTeam.addPoints(homeTeamWin);
        awayTeam.addPoints(awayTeamWin);

        for (int i = 0; i < sets.length - 1; i++) {
            //((SingleSet)sets[i]).submitSetScore();
            ((SingleSet) sets[i]).submitSetScore();

        }

        ((DoubleSet) sets[4]).submitSetScore();

    }

    public SetScore[] getSets() {
        return sets;
    }

    public void setSets(SetScore[] sets) {
        this.sets = sets;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    @Override
    public String toString() {
        String setString = "";
        for (SetScore s : sets) {
            setString += s.toString();
        }
        return "MatchScore{" + "homeTeam=" + homeTeam + ", awayTeam=" + awayTeam
                + ", sets=" + setString + ", homeTeamWin=" + homeTeamWin + ", awayTeamWin=" + awayTeamWin + '}';
    }

}
