package tennisossd;

public class DoubleSet extends SetScore {

    Player homePlayer2, awayPlayer2;

    /**
     *
     * @param setNum
     * @param hp
     * @param ap
     * @param hp2
     * @param ap2
     */
    public DoubleSet(int setNum, Player hp, Player ap, Player hp2, Player ap2) {
        super(setNum, hp, ap);
        this.homePlayer2 = hp2;
        this.awayPlayer2 = ap2;
    }

    // Finalises the scores for the home and away players
    @Override
    public void submitSetScore() {
    }

    @Override
    public String toString() {
        return "DoubleSet{" + "hp2=" + homePlayer2 + ", ap2=" + awayPlayer2 + '}';
    }

}
