package org.example;

public class Player {
    int id;
     String name;
     int wickets;
     int runs;
     int role;

    Player(String n) {
        name = n;
        runs = 0;
        wickets = 0;
    }
    Player(int id, String n, int role) {
        this.id = id;
        name = n;
        runs = 0;
        wickets = 0;
        this.role = role;
    }
    Player(int id, String s, int r, int role) {
        this.id = id;
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
