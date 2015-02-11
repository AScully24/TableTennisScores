package tennisossd;

import java.util.ArrayList;

public class RegistrationManager {

    ArrayList<Player> players = new ArrayList<>();
    ArrayList<Team> teams = new ArrayList<>();

    public void addTeam(Team t) {
        teams.add(t);
    }

    public Team getTeam(String teamName) {
        int index = teams.indexOf(new Team(teamName, teamName));

        if (index < 0) {
            return null;
        } else {
            return teams.get(index);
        }
    }

    public void regPlayerToTeam(Player p, Team t) {
        for (Team ti : teams) {
            if (ti.getName().equals(t.getName())) {
                ti.addMember(p);
                break;
            }
        }
        players.add(p);

    }

    public ArrayList<Team> getAllTeams() {
        return teams;
    }

    public ArrayList<Player> getAllPlayers() {
        return players;
    }

    public boolean isTeamValid(Team t) {
        return teams.contains(t);
    }
}
