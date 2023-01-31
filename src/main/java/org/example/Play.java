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
            Random r = new Random();
            int run = r.nextInt(8 - 0);

            if(run == 1) {
                scoreByCurrentPlayer += 1;
                score += 1;
            }
            else if(run == 2) {
                scoreByCurrentPlayer += 2;
                score += 2;
            }
            else if(run == 3) {
                scoreByCurrentPlayer += 3;
                score += 3;
            }
            else if(run == 4) {
                scoreByCurrentPlayer += 4;
                score += 4;
            }
            else if(run == 5) {
                scoreByCurrentPlayer += 5;
                score += 5;
            }
            else if(run == 6) {
                scoreByCurrentPlayer += 6;
                score += 6;
            }
            else if(run == 7) {
                t.team.set(wickets, new Player(t.team.get(wickets).name, scoreByCurrentPlayer));
                scoreByCurrentPlayer = 0;
                wickets += 1;
            }

            numberOfBalls--;
        }
//        Check this 🚨🚨
        if(wickets != 10 ) {
            t.team.set(wickets, new Player(t.team.get(wickets).name, scoreByCurrentPlayer));
        }

        System.out.println("Runs by Each Player of the Team : ");
        for(Player curr  : t.team) {
            System.out.println(curr.name + " scored  " + curr.runs);
        }
        System.out.println("Total Score : " + score + "    Wickets : " + wickets + "    BallsPlayed : " + (overs*6 - numberOfBalls));
    }

    public int getScore() {
        return score;
    }
}
