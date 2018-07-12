package com.ena;

import java.util.ArrayList;

public class Opponent extends Team {

    private static ArrayList<Player> opponentTeam = new ArrayList<>();
    private static int power;

    public Opponent(String name) {
        super(name);
    }


    public ArrayList<Player> createopponentTeam() {

        for (int i = 0; i < 1; i++) {
            opponentTeam.add(new Player(Position.GOALIE, Player.randomQuality(), Player.randomSpeed()));
        }

        for (int i = 0; i < 3; i++) {
            opponentTeam.add(new Player(Position.DEFENDER, Player.randomQuality(), Player.randomSpeed()));
        }

        for (int i = 0; i < 5; i++) {
            opponentTeam.add(new Player(Position.MIDFIELDER, Player.randomQuality(), Player.randomSpeed()));
        }

        for (int i = 0; i < 2; i++) {
            opponentTeam.add(new Player(Position.STRIKER, Player.randomQuality(), Player.randomSpeed()));
        }

        return opponentTeam;
    }


    // team quality
    private static int sumTeamQuality(ArrayList<Player> list) {
        int sum = 0;
        for (Player player:list) {
            sum += player.getQuality();
        }
        return sum;
    }


    // team speed
    private static int sumSpeed(ArrayList<Player> list) {
        int sum = 0;
        for (Player player:list) {
            if (player.getPosition() == Position.STRIKER) {
                sum += player.getSpeed();
            }
        }
        return sum;
    }


    public static int teamPower() {
        power = sumTeamQuality(opponentTeam) + sumSpeed(opponentTeam);
        return power*2;
    }


    public void print(ArrayList<Player> list) {
        System.out.println("Opponent team players:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }






}
