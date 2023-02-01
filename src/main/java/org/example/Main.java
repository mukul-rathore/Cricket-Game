package org.example;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Cricket Game!!! 🏏");
        System.out.println("Press 0 to start the game");
        System.out.println("Press 1 to exit the game");

        int startGame;
        Scanner sc = new Scanner(System.in);
        startGame = sc.nextInt();

        if(startGame == 1) {
            System.out.println("Exited the Game successfully!");
            return;
        }
        else if(startGame != 0) {
            System.out.println("Enter the wrong number");
            System.out.println("Exited the Game successfully!");
            return;
        }

        int overs;
        System.out.println("Enter the number of overs b/w 0 to 20:");
        overs = sc.nextInt();
        if(overs < 0 || overs > 20) {
            System.out.println("Please enter the number of overs b/w 0 to 20");
            System.out.println("Exited the Game successfully!");
            return;
        }
        NewGame newGame = new NewGame(overs);
        newGame.teamsPlay();
        System.out.println("-------------------------------------  Game Results --------------------------------");
        newGame.printWinner();
        System.out.println("Game ended Successfully");

    }
}