package tennisossd;

import java.util.ArrayList;

public class Team {

    private String name, venue;
    private int pointsWon;
    private ArrayList<Player> players = new ArrayList<>();

    public Team(String name, String venue) {
        this.name = name;
        this.venue = venue;
    }

    /**
     *
     * @param p
     */
    public void addMember(Player p) {
        players.add(p);
        pointsWon += p.getSetsWons();
    }

    public boolean isPlayerValid(String playerName) {
        return players.contains(new Player(playerName));
    }

    public void addPoints(int p) {
        pointsWon += p;
    }

    public int getPointsWon() {
        return pointsWon;
    }

    public String getName() {
        return name;
    }

    public String getVenue() {
        return venue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public void setPointsWon(int pointsWon) {
        this.pointsWon = pointsWon;
    }

    /**
     *
     * @param players
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    /**
     *
     * @param playerName
     * @return
     */
    public Player getPlayer(String playerName) {
        int i = players.indexOf(new Player(playerName));
        if (i > -1) {
            return players.get(i);
        }
        return null;

    }

    @Override
    public String toString() {
        return "Team{" + "name=" + name + ", venue=" + venue + ", pointsWon="
                + pointsWon + "}\n";
    }

    public String toCSV() {
        return name + "," + venue + "," + pointsWon + "\n";
    }

    /**
     *
     * @return
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof Team) {
            return this.name.equals(((Team) o).getName());
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
