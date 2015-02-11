package tennisossd;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Test {

    public static void main(String[] args) {

        importTeamData();

    }

    public static void importTeamData() {
        Scanner scData = null;
        RegistrationManager rm = new RegistrationManager();
        
        scData = new Scanner(Test.class.getResourceAsStream("/team_data.txt"));
        scData.nextLine();
        while (scData.hasNextLine()) {
            String lineData[] = scData.nextLine().split(",");
            Team t = new Team(lineData[0], lineData[1]);
            t.addPoints(Integer.parseInt(lineData[2]));
            rm.addTeam(t);
        }
        
        scData.close();
        scData = null;
        scData = new Scanner(Test.class.getResourceAsStream("/player_data.txt"));
        scData.nextLine();
        while (scData.hasNextLine()) {
            String lineData[] = scData.nextLine().split(",");
            Player p = new Player(lineData[0]);
            p.setSetsPlayed(Integer.parseInt(lineData[1]));
            p.setSetsWons(Integer.parseInt(lineData[2]));
            Team t = new Team(lineData[3], lineData[3]);
            rm.regPlayerToTeam(p, t);
        }
    }
    
    public void arraySearching() {

        ArrayList<Player> players = new ArrayList<>();

        Player p = new Player("hi");
        players.add(p);

        p = new Player("bob");
        players.add(p);

        p = new Player("tom");
        players.add(p);

        p = new Player("jack");
        players.add(p);

        p = new Player("tom");
        players.add(p);

        for (Player searchPlayer : players) {
            if (searchPlayer.getName().equals("bob")) {
                System.out.println("Found Bob");
            }
        }

        System.out.println(players.contains(p));

    }
}
