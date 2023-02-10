package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Team {
    List<Player> team = new ArrayList<>(11);

    Team(int t) {
        team = getTeamDetails(t);
    }
    List<Player> getTeamDetails(int t) {
        Object obj;

        try {
            obj = new JSONParser().parse(new FileReader("src/main/java/org/example/teams.json"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        JSONObject jo = (JSONObject) obj;


        JSONArray ja = (JSONArray) jo.get(getTeamName(t));

        List<Player> currTeam = new ArrayList<>();
        for(int i=0; i< ja.size(); i++) {
            String tempPlayer = (String) ja.get(i);
            Player p = new Player(i, tempPlayer, (i <= 6)? 0 : 1);

            currTeam.add(p);

            System.out.println("Player " + i + "  : " + tempPlayer);
            System.out.println("            Role : " + ((p.role == 0)? "Batsman " : "Bowler"));
        }

//        for(Player p : currTeam) {
//            p.printDetails();
//        }

        return currTeam;
    }

    String getTeamName(int n) {
        if(n == 0) return "India";
        else if(n == 1) return "Pakistan";
        else if(n == 2) return "Australia";
        else return "England";
    }

}
