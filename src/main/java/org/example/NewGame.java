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
        team1.startGame();
        team2.startGame();
    }

    public void printWinner() {
        int team1Score = team1.getScore();
        int team2Score = team2.getScore();
        System.out.println("Team1 Score : " + team1Score);
        System.out.println("Team2 Score : " + team2Score);

        if(team1Score > team2Score) System.out.println("Team1 is Winner!!!");
        else if (team1Score < team2Score) System.out.println("Team2 is Winner!!!");
        else System.out.println("Match Tied");
    }
}
