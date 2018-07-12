package com.ena;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Team implements Formation {

    private String name;
    private String nameFormation;

    public Team(String name) {
        this.name = name;
    }

    private ArrayList<Player> allPlayers = new ArrayList<>();
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Player> playersOnBench = new ArrayList<>();

    ArrayList<Player> golmani = new ArrayList<>();
    ArrayList<Player> odbrana = new ArrayList<>();
    ArrayList<Player> sredina = new ArrayList<>();
    ArrayList<Player> napadaci = new ArrayList<>();

    public static int power;

    ////////////////////////////////////////////////////////////////////////////////
    public ArrayList<Player> createTeamBig() {

        // treba mi 22 ukupno

        // 2 golmana pravim:
        for (int i = 0; i < 2; i++) {
            allPlayers.add(new Player(Position.GOALIE, Player.randomQuality(), Player.randomSpeed()));
        }

        // pravim 6 odbrana:
        for (int i = 0; i < 6; i++) {
            allPlayers.add(new Player(Position.DEFENDER, Player.randomQuality(), Player.randomSpeed()));
        }

        // pravim 10 veznika
        for (int i = 0; i < 10; i++) {
            allPlayers.add(new Player(Position.MIDFIELDER, Player.randomQuality(), Player.randomSpeed()));
        }

        // pravim 4 napadaca
        for (int i = 0; i < 4; i++) {
            allPlayers.add(new Player(Position.STRIKER, Player.randomQuality(), Player.randomSpeed()));
        }

        return allPlayers;

    }
////////////////////////////////////////////////////////////////////////////////

    @Override
    public ArrayList<Player> defenseFormation() {

        sortedPlayerByPosition();

        // formating 5-4-1
        for (int i = 0; i < 1; i++) {
            players.add(golmani.get(i));
            allPlayers.remove(golmani.get(i));
        }

        for (int i = 0; i < 5; i++) {
            players.add(odbrana.get(i));
            allPlayers.remove(odbrana.get(i));
        }

        for (int i = 0; i < 4; i++) {
            players.add(sredina.get(i));
            allPlayers.remove(sredina.get(i));
        }

        for (int i = 0; i < 1; i++) {
            players.add(napadaci.get(i));
            allPlayers.remove(napadaci.get(i));
        }

        for (Player p : allPlayers) {
            playersOnBench.add(p);
        }

        return players;
    }


    private void sortedPlayerByPosition() {

        for (Player pl : allPlayers) {
            if (pl.getPosition() == Position.GOALIE) {
                golmani.add(pl);
            }

            if (pl.getPosition() == Position.DEFENDER) {
                odbrana.add(pl);
            }

            if (pl.getPosition() == Position.MIDFIELDER) {
                sredina.add(pl);
            }

            if (pl.getPosition() == Position.STRIKER) {
                napadaci.add(pl);
            }
        }

        Collections.sort(golmani);
        Collections.sort(odbrana);
        Collections.sort(sredina);

        Comparator<Player> bestSpeed = new Comparator<Player>() {
            @Override
            public int compare(Player p1, Player p2) {
                if (p1.getSpeed() < p2.getSpeed())
                    return 1;
                else
                    return -1;
            }
        };

        Collections.sort(napadaci, bestSpeed);

    }


    @Override
    public ArrayList<Player> fourFourTwoFormation() {
        sortedPlayerByPosition();

        // formating 5-4-1
        for (int i = 0; i < 1; i++) {
            players.add(golmani.get(i));
            allPlayers.remove(golmani.get(i));
        }

        for (int i = 0; i < 4; i++) {
            players.add(odbrana.get(i));
            allPlayers.remove(odbrana.get(i));
        }

        for (int i = 0; i < 4; i++) {
            players.add(sredina.get(i));
            allPlayers.remove(sredina.get(i));
        }

        for (int i = 0; i < 2; i++) {
            players.add(napadaci.get(i));
            allPlayers.remove(napadaci.get(i));
        }

        for (Player p : allPlayers) {
            playersOnBench.add(p);
        }

        return players;
    }

    @Override
    public ArrayList<Player> attackFormation() {
        sortedPlayerByPosition();

        // formating 5-4-1
        for (int i = 0; i < 1; i++) {
            players.add(golmani.get(i));
            allPlayers.remove(golmani.get(i));
        }

        for (int i = 0; i < 3; i++) {
            players.add(odbrana.get(i));
            allPlayers.remove(odbrana.get(i));
        }

        for (int i = 0; i < 4; i++) {
            players.add(sredina.get(i));
            allPlayers.remove(sredina.get(i));
        }

        for (int i = 0; i < 3; i++) {
            players.add(napadaci.get(i));
            allPlayers.remove(napadaci.get(i));
        }

        for (Player p : allPlayers) {
            playersOnBench.add(p);
        }

        return players;
    }


    //printing...
    public void print(ArrayList<Player> spisak) {

        for (int i = 0; i < spisak.size(); i++) {
            System.out.println((i + 1) + ". " + spisak.get(i));
        }
    }

    //printing...all 22
    public void printEveryone() {
        System.out.println("\nAll 22 players : ");
        for (int i = 0; i < allPlayers.size(); i++) {
            System.out.println((i + 1) + ". " + allPlayers.get(i));
        }
        System.out.println("\n----------------------------------\n");
    }

    //printing...my team
    public void printMyTeam() {
        System.out.println("\nMine 11 players : ");
        for (int i = 0; i < players.size(); i++) {
            System.out.println((i + 1) + ". " + players.get(i));
        }
        System.out.println("\n----------------------------------\n");
    }


    public void onBenchIs() {
        System.out.println("Players on bench:");

        for (Player p : playersOnBench) {
            System.out.println(p);
        }
    }

//    private int injuredPlayerRandom() {
//        Random random = new Random();
//        int indexInjured = random.nextInt(players.size());
//        System.out.println(players.get(indexInjured) + " is injured!");
//        players.remove(indexInjured);
////        players.remove(random.nextInt(players.size()));
//        System.out.println("He left, now I have:");
//        for (int i=0;i<players.size();i++){
//            System.out.println((i+1)+". " + players.get(i));
//        }
//        return indexInjured;
//    }

    public void playerReplacement() {
        ////////////////////////////////////////////////////////////////////
        Random random = new Random();
        int indexInjured = random.nextInt(players.size());
        System.out.println(players.get(indexInjured) + " is injured!");
        System.out.println("Index povredjenog " + indexInjured);


        // zavisno od formacije ... ubacujem jednog od preostalih
        if (nameFormation.equals("defence")) {

            for (int i = 0; i < playersOnBench.size(); i++) {

                if (players.get(indexInjured).getPosition() == Position.GOALIE) {
                    players.remove(indexInjured);
                    players.add(indexInjured, playersOnBench.get(0));
                    System.out.println("player is replaced with " + playersOnBench.get(0));
//                    return players.get(0);
                    return;
                } else if (players.get(indexInjured).getPosition() == Position.DEFENDER) {
                    System.out.println("player is replaced with " + playersOnBench.get(1));
                    players.remove(indexInjured);
                    players.add(indexInjured, playersOnBench.get(1)); // znam da je na tom mestu u ovoj formaciji
//                    return playersOnBench.get(0);
                    return;
                } else if (players.get(indexInjured).getPosition() == Position.MIDFIELDER) {
                    int min = 2;
                    int max = 7;
                    int index = random.nextInt(max - min + 1) + min;
                    //int index = random.nextInt(7)+2;
                    System.out.println("player is replaced with " + playersOnBench.get(index) + " on index " + index);
                    players.remove(indexInjured);
                    players.add(indexInjured, playersOnBench.get(index));
//                    return players.get(index);
                    return;
                } else {
                    int min = 8;
                    int max = 10;
//                    int index = random.nextInt(10)+8; // od 8-10 indexi
                    int index = random.nextInt(max - min + 1) + min;
                    System.out.println("player is replaced with " + playersOnBench.get(index) + " on index " + index);
                    players.remove(indexInjured);
                    players.add(indexInjured, playersOnBench.get(index));
//                    return players.get(index);
                    return;
                }
            }
        }
        // formacija kada su isti
        if (nameFormation.equals("4-4-2")) {
            for (int i = 0; i < playersOnBench.size(); i++) {

                if (players.get(indexInjured).getPosition() == Position.GOALIE) {
                    players.add(indexInjured, playersOnBench.get(0));
                    System.out.println("player is replaced with " + playersOnBench.get(0));
                    players.remove(indexInjured);
                    return;
//                    return players.get(0);
                    // playersOnBench.remove(0);
                } else if (players.get(indexInjured).getPosition() == Position.DEFENDER) {
                    int index = random.nextInt(2) + 1;
                    System.out.println("player is replaced with " + playersOnBench.get(index) + " on index " + index);
                    players.remove(indexInjured);
                    players.add(indexInjured, playersOnBench.get(index));
                    return;
//                    return players.get(index);
                } else if (players.get(indexInjured).getPosition() == Position.MIDFIELDER) {
                    int min = 3;
                    int max = 8;
                    int index = random.nextInt(max - min + 1) + min;
                    // int index = random.nextInt(8)+3;
                    System.out.println("player is replaced with " + playersOnBench.get(index) + " on index " + index);
                    players.remove(indexInjured);
                    players.add(indexInjured, playersOnBench.get(index));
                    return;
//                    return players.get(index);
                } else {
                    int min = 9;
                    int max = 10;
                    int index = random.nextInt(max - min + 1) + min;
                    //int index = random.nextInt(10)+9; // od 8-10 indexi
                    players.remove(indexInjured);
                    System.out.println("player is replaced with " + playersOnBench.get(index) + " on index " + index);
                    players.add(indexInjured, playersOnBench.get(index));
                    return;
//                    return players.get(index);

                }
            }
        }


        // formacija attack
        if (nameFormation.equals("attack")) {
            for (int i = 0; i < playersOnBench.size(); i++) {

                if (players.get(indexInjured).getPosition() == Position.GOALIE) {
                    players.remove(indexInjured);
                    players.add(indexInjured, playersOnBench.get(0));
                    System.out.println("player is replaced with " + players.get(0));
                    return;
//                    return players.get(0);
                    // playersOnBench.remove(0);
                } else if (players.get(indexInjured).getPosition() == Position.DEFENDER) {
                    int min = 1;
                    int max = 3;
                    int index = random.nextInt(max - min + 1) + min;

//                  int index = random.nextInt(3)+1;
                    System.out.println("player is replaced with " + playersOnBench.get(index) + " on index " + index);
                    players.remove(indexInjured);
                    players.add(indexInjured, playersOnBench.get(index));
                    return;
//                    return players.get(index);
                } else if (players.get(indexInjured).getPosition() == Position.MIDFIELDER) {
                    int min = 4;
                    int max = 9;
                    int index = random.nextInt(max - min + 1) + min;
                    System.out.println("player is replaced with " + playersOnBench.get(index) + " on index " + index);
                    players.remove(indexInjured);
                    players.add(indexInjured, playersOnBench.get(index));
                    return;
//                    return players.get(index);
                } else {
                    System.out.println("player is replaced with " + playersOnBench.get(10));
                    players.remove(indexInjured);
                    players.add(indexInjured, playersOnBench.get(10)); // znam da je ovde , jedan je ostao
                    return;
//                    return players.get(10);
                }
            }
        }



    }


    /////////////////////////////////////////////////////////////////////


    // team quality
    private int sumTeamQuality(ArrayList<Player> list) {
        int sum = 0;
        for (Player player : list) {
            sum += player.getQuality();
        }
        return sum;
    }


    // team speed
    private int sumSpeed(ArrayList<Player> list) {
        int sum = 0;
        for (Player player : list) {
            if (player.getPosition() == Position.STRIKER) {
                sum += player.getSpeed();
            }
        }
        return sum;
    }


    public int teamPowerAll() {
        int power = sumTeamQuality(allPlayers) + sumSpeed(allPlayers);
        return power;
    }

    public int teamPowerFormated() {

        power = sumTeamQuality(players) + sumSpeed(players);
        return power;
    }

    public void amIStronger() {
        int myTeamAtStart = teamPowerAll();
        int oppTeamAtStart = Opponent.teamPower();


        System.out.println("Power of my team: " + myTeamAtStart + "" +
                "\nPower of opponent team " + oppTeamAtStart);


        if (myTeamAtStart > oppTeamAtStart) {
            int difference = myTeamAtStart - oppTeamAtStart;
            if (difference<=50){
                System.out.println("You are equal --> 4-4-2 Formation created");
                nameFormation = "4-4-2";
                this.fourFourTwoFormation();
                return;
            }
            System.out.println("I am stronger --> 3-4-3 Formation created");
            nameFormation = "attack";
            this.attackFormation();


        } else if (myTeamAtStart < oppTeamAtStart) {
            int difference = oppTeamAtStart - myTeamAtStart;
            if (difference<=50){
                System.out.println("You are equal --> 4-4-2 Formation created");
                nameFormation = "4-4-2";
                this.fourFourTwoFormation();
                return;
            }
            System.out.println("They are stronger --> 5-4-1 Formation created");
            nameFormation = "defence";
            this.defenseFormation();


        } else {
            System.out.println("You are equal --> 4-4-2 Formation created");
            nameFormation = "4-4-2";
            this.fourFourTwoFormation();

        }
    }


    public static Team theWinnerIs(Team t1, Team t2) {
        Random random = new Random();
        int winn = random.nextInt(2) + 1;
        if (winn == 1) {
            return t1;
        } else
            return t2;
    }


    @Override
    public String toString() {
        return " ----> " + name;
    }
}
