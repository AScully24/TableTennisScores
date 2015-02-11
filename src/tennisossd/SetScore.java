package tennisossd;

import java.util.ArrayList;

public abstract class SetScore {

    int setNum, homeWins = 0, awayWins = 0;
    Player homePlayer1, awayPlayer1;
    ArrayList<GameScore> gameScores = new ArrayList<>();

    public SetScore(int setNum, Player hp, Player ap) {
        this.setNum = setNum;
        this.homePlayer1 = hp;
        this.awayPlayer1 = ap;
    }

    // Saves the scores to the GameScore array list.
    public void enterSetScores(int h1, int a1, int h2, int a2, int h3, int a3) {
        GameScore gs = new GameScore();
        gs.setGameScore(h1, a1);
        gameScores.add(gs);

        gs = new GameScore();
        gs.setGameScore(h2, a2);
        gameScores.add(gs);

        gs = new GameScore();
        gs.setGameScore(h3, a3);
        gameScores.add(gs);

    }

    // Checks who has won the set. 
    public void calculateHomeWin() {
        for (GameScore gs : gameScores) {
            if (gs.getHPlayerPts() > gs.getAPlayerPts()) {
                homeWins++;
            } else {
                awayWins++;
            }
        }

        if (homeWins > awayWins) {
            homeWins = 1;
            awayWins = 0;
        } else {
            homeWins = 0;
            awayWins = 1;
        }
    }

    //Finalises the scores for the home and away players.
    public abstract void submitSetScore();

    public Player getHomePlayer1() {
        return homePlayer1;
    }

    public Player getAwayPlayer1() {
        return awayPlayer1;
    }

    public ArrayList<GameScore> getGameScores() {
        return gameScores;
    }

    public int getSetNum() {
        return setNum;
    }

    public void setSetNum(int setNum) {
        this.setNum = setNum;
    }

    public int getHomeWins() {
        return homeWins;
    }

    public void setHomeWins(int homeWins) {
        this.homeWins = homeWins;
    }

    public int getAwayWins() {
        return awayWins;
    }

    public void setAwayWins(int awayWins) {
        this.awayWins = awayWins;
    }

    public void setHomePlayer1(Player homePlayer1) {
        this.homePlayer1 = homePlayer1;
    }

    public void setAwayPlayer1(Player awayPlayer1) {
        this.awayPlayer1 = awayPlayer1;
    }

    public void setGameScores(ArrayList<GameScore> gameScores) {
        this.gameScores = gameScores;
    }

    @Override
    public String toString() {
        return "SetScore{" + "setNum=" + setNum + ", homeWins=" + homeWins + ", awayWins=" + awayWins + ", homePlayer1=" + homePlayer1 + ", awayPlayer1=" + awayPlayer1 + ", gameScores=" + gameScores + '}';
    }
}
