package org.example;
import java.util.*;
public class NewGame {
    private int overs;
    private Play team1;
    private Play team2;
    NewGame(int overs) {
        this.overs = overs;
        team1 = new Play(overs);
        team2 = new Play(overs);
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
        team1.startGame(team_1);
        System.out.println("--------------------------------------  Second Innings ----------------------------------");
        team2.startGame(team_2);
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
}
