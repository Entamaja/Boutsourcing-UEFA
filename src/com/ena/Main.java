package com.ena;

public class Main {

    public static void main(String[] args) {


        Team myTeam = new Team("Tim Srbija");
        myTeam.createTeamBig();
        myTeam.printEveryone();


        Opponent opponentTeam = new Opponent("Tim Brazil");
        opponentTeam.print(opponentTeam.createopponentTeam());




        myTeam.amIStronger();
        myTeam.printMyTeam();

        Team winnerTeamIs = Team.theWinnerIs(myTeam, opponentTeam);
        System.out.println("The winner is " + winnerTeamIs);


        myTeam.onBenchIs();
        myTeam.playerReplacement();

        myTeam.printMyTeam();


    }
}
