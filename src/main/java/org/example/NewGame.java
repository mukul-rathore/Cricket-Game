package org.example;
import org.example.config.Config;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class NewGame {
    private int overs;
    private Play team1;
    private Play team2;

    private Connection connection;
    NewGame(int overs) {
        this.overs = overs;
        team1 = new Play(overs);
        team2 = new Play(overs);
        connection = Config.getConnection();
    }

    public void teamsPlay() {
        // Write team selection code here

        System.out.println("Enter the number for the Team");
        System.out.println("0 for India");
        System.out.println("1 for Pakistan");
        System.out.println("2 for Australia");
        System.out.println("3 for England");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Team 1 Code : ");
        int t1 = sc.nextInt();
        Team team_1 = new Team(t1);
        System.out.println("Enter Team 2 Code : ");
        int t2 = sc.nextInt();
        Team team_2 = new Team(t2);

        System.out.println("--------------------------------------  First Innings -----------------------------------");
        team1.startGame(team_1, 10000);

        for (Player player : team_1.team) {
            String role = player.role == 0 ? "Batsman" : "Bowler";
            String sql = "Insert into team1_scorecard (player_id, player_name, runs, player_role) " +
                    "values(" + player.id + ",'" + player.name + "'," +player.runs + ",'" + role +"');";
//            System.out.println(sql);
            try {
                Statement statement = connection.createStatement();
                statement.execute(sql);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
//            System.out.println(player.name);
//            System.out.println(player.runs);
//            System.out.println(player.wickets);
//            System.out.println(player.role == 0 ? "Batsman" : "Bowler");
        }

        String team1Name = getTeamName(t1);
        int team1PlayedBalls = team1.getOvers();
        int team1Score = team1.getScore();
        int team1Wickets = team1.getWickets();

        System.out.println("--------------------------------------  Second Innings ----------------------------------");
        team2.startGame(team_2, team1Score);

        for (Player player : team_2.team) {
            String role = player.role == 0 ? "Batsman" : "Bowler";
            String sql = "Insert into team2_scorecard (player_id, player_name, runs, player_role) " +
                    "values(" + player.id + ",'" + player.name + "'," +player.runs + ",'" + role +"');";
            try {
                Statement statement = connection.createStatement();
                statement.execute(sql);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
//            System.out.println(player.name);
//            System.out.println(player.runs);
//            System.out.println(player.wickets);
//            System.out.println(player.role == 0 ? "Batsman" : "Bowler");
        }

        String team2Name = getTeamName(t2);
        int team2PlayedBalls = team2.getOvers();
        int team2Score = team2.getScore();
        int team2Wickets = team2.getWickets();

        String team1Status = getSatus(team1Score, team2Score, 0);
        String team2Status = getSatus(team1Score, team2Score, 1);



        String team1SQL = "Insert into final_scorecard (team_name, team_score, team_wickets, team_ballsPlayed , game_status) " +
                "values('" + team1Name+ "'," + team1Score + "," + team1Wickets + "," +team1PlayedBalls+ ",'" + team1Status+ "');";
        String team2SQL = "Insert into final_scorecard (team_name, team_score, team_wickets, team_ballsPlayed , game_status) " +
                "values('" + team2Name+ "'," + team2Score + "," + team2Wickets + "," +team2PlayedBalls+ ",'" + team2Status+ "');";

        try {
            Statement statement = connection.createStatement();
            statement.execute(team1SQL);
            statement.execute(team2SQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getTeamName(int id) {
        if(id == 0) return "India";
        else if(id == 1) return "Pakistan";
        else if(id == 2) return "Australia";
        else return "England";
    }
    public void printWinner() {
        int team1Score = team1.getScore();
        int team2Score = team2.getScore();
        System.out.println("Team1 Score : "  + team1Score);
        System.out.println("Team2 Score : " + team2Score);

        if(team1Score > team2Score) System.out.println("Team1 is Winner!!!");
        else if (team1Score < team2Score) System.out.println("Team2 is Winner!!!");
        else System.out.println("Match Tied");
    }

    String getSatus(int team1Score, int team2Score, int forTeam) {
        if(forTeam == 0) {
            if(team1Score > team2Score) return "Won" ;
            else if (team1Score < team2Score) return "Lost" ;
            else return "Tied";
        }
        else {
            if(team1Score > team2Score) return "Lost" ;
            else if (team1Score < team2Score) return "Won" ;
            else return "Tied";
        }
    }
}
