package tennisossd;

public class SingleSet extends SetScore {

    public SingleSet(int setNum, Player hp, Player ap) {
        super(setNum, hp, ap);
    }

    @Override
    public void submitSetScore() {

        if (homeWins > awayWins) {
            homePlayer1.incSetWons();
        } else {
            awayPlayer1.incSetWons();
        }

        // Increases the number of games played for each player.
        homePlayer1.incSetPlayed();
        awayPlayer1.incSetPlayed();
    }

}
