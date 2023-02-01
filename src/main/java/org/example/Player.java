package org.example;

public class Player {
     String name;
     int wickets;
     int runs;
     int role;

    Player(String n) {
        name = n;
        runs = 0;
        wickets = 0;
    }
    Player(String n, int role) {
        name = n;
        runs = 0;
        wickets = 0;
        this.role = role;
    }
    Player(String s, int r, int role) {
        name = s;
        runs = r;
        wickets = 0;
        this.role = role;
    }

    void printDetails() {
        System.out.println("Name : "  + name);
        System.out.println("Runs : " + runs);
        System.out.println("Wickets : " + wickets);
        System.out.println("Role : " + ((role == 0)? "Batsman" : "Bowler"));
        System.out.println();
    }

    void setRuns(int r) {
        runs = r;
    }
}
