package tennisossd;

public class GameScore {

    int hPlayerPts, aPlayerPts;

    public void setGameScore(int n1, int n2) {
        this.hPlayerPts = n1;
        this.aPlayerPts = n2;
    }

    public int getHPlayerPts() {
        return hPlayerPts;
    }

    public int getAPlayerPts() {
        return aPlayerPts;
    }

    @Override
    public String toString() {
        return "GameScore{" + "hPlayerPts=" + hPlayerPts + ", aPlayerPts=" + aPlayerPts + '}';
    }

}
