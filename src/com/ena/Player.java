package com.ena;

import java.util.Random;

public class Player implements Comparable<Player> {


    private Position position;
    private int quality;
    private int speed;


    public Player(Position position, int quality, int speed) {
        this.position = position;
        this.quality = quality;
        this.speed = speed;
    }


    public static int randomSpeed() {

        Random random = new Random();
        int min = 5;  // npr min trce 5 na sat,
        int max = 30; // max 30 na sat
        int speed = random.nextInt(max - min + 1) + min; // random koliko trce

        return speed;
    }

    public static int randomQuality() {

        Random random = new Random();
        return random.nextInt(10) + 1; // 1-10 po kvalitetu

    }

    @Override
    public String toString() {
        return "Player on position " + position + ", has quality " + quality + " and he can run ... " + speed + " km/h";
    }

    @Override
    public int compareTo(Player player) {
        if (this.getQuality() < player.getQuality())
            return 1;
        // ako je kvalitet isti onda bolje brzeg
        if (this.getQuality() == player.getQuality()) {
            if (this.getSpeed() < player.getSpeed()) return 1;
            else return -1;
        } else
            return -1;
    }


// getteri i setteri

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }


}
