package org.example;
import java.util.*;

public class Play {
    private int overs;
    private int wickets;
    private int score;
    Play(int overs) {
        score = 0;
        wickets = 0;
        this.overs = overs;
    }

    public void startGame() {
        int numberOfBalls = overs*6;
        while(wickets != 10 && numberOfBalls != 0) {
            Random r = new Random();
            int run = r.nextInt(8 - 0);

            if(run == 1) score += 1;
            else if(run == 2) score += 2;
            else if(run == 3) score += 3;
            else if(run == 2) score += 4;
            else if(run == 5) score += 5;
            else if(run == 6) score += 6;
            else wickets += 1;

            numberOfBalls--;
        }

        System.out.println("Score : " + score + "    Wickets : " + wickets + "    BallsPlayed : " + (overs*6 - numberOfBalls));
    }

    public int getScore() {
        return score;
    }
}
