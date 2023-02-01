package org.example;
import java.util.*;

public class Play {
    private int overs;
    private int wickets;
    private int score;
    List<Player> players;
    Play(int overs) {
        score = 0;
        wickets = 0;
        this.overs = overs;
    }
    Play (int overs, List<Player> li) {
        score = 0;
        wickets = 0;
        this.overs = overs;
        players = li;
    }

    public void startGame(Team t) {
        int numberOfBalls = overs*6;
        int scoreByCurrentPlayer = 0;
        while(wickets != 10 && numberOfBalls != 0) {
            int roleOfCurrentPlayer = t.team.get(wickets).role;
            int run = generateRunsByRole(roleOfCurrentPlayer);

            scoreByCurrentPlayer = getScoreByCurrentPlayer(t, scoreByCurrentPlayer, run);

            numberOfBalls--;
        }

        if(wickets != 10 ) {
            t.team.set(wickets, new Player(t.team.get(wickets).name, scoreByCurrentPlayer, t.team.get(wickets).role));
        }

        System.out.println("Runs by Each Player of the Team : ");
        for(Player curr  : t.team) {
            System.out.println(curr.name + " scored  " + curr.runs);
        }
        System.out.println("Total Score : " + score + "    Wickets : " + wickets + "    BallsPlayed : " + (overs*6 - numberOfBalls));
    }

    private int getScoreByCurrentPlayer(Team t, int scoreByCurrentPlayer, int run) {
        switch (run) {
            case 1 -> {
                scoreByCurrentPlayer += 1;
                score += 1;
            }
            case 2 -> {
                scoreByCurrentPlayer += 2;
                score += 2;
            }
            case 3 -> {
                scoreByCurrentPlayer += 3;
                score += 3;
            }
            case 4 -> {
                scoreByCurrentPlayer += 4;
                score += 4;
            }
            case 5 -> {
                scoreByCurrentPlayer += 5;
                score += 5;
            }
            case 6 -> {
                scoreByCurrentPlayer += 6;
                score += 6;
            }
            case 7 -> {
                t.team.set(wickets, new Player(t.team.get(wickets).name, scoreByCurrentPlayer, t.team.get(wickets).role));
                scoreByCurrentPlayer = 0;
                wickets += 1;
            }
        }
        return scoreByCurrentPlayer;
    }

    private int generateRunsByRole(int role) {
        int randomArray[];

        //    role == 0    means    Batsman
        //    role == 1    means    Bowler

        if(role == 0) randomArray = new int[] {0,1,1,1,1,2,2,2,3,3,7,4,4,4,5,6,6};
        else randomArray = new int[] {0,0,0,0,1,1,1,2,2,3,4,5,6,7,7,7,7};

        Random r = new Random();
        int run = r.nextInt(17);
        return randomArray[run];
    }
    public int getScore() {
        return score;
    }
}
