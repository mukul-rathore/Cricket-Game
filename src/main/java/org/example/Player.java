package org.example;

public class Player {
     String name;
     int wickets;
     int runs;

    Player(String n) {
        name = n;
        runs = 0;
        wickets = 0;
    }
    Player(String s, int r) {
        name = s;
        runs = r;
        wickets = 0;
    }

    void printDetails() {
        System.out.println("Name : "  + name);
        System.out.println("Runs : " + runs);
        System.out.println("Wickets : " + wickets);
    }

    void setRuns(int r) {
        runs = r;
    }
}
