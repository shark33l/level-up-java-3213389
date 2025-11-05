package com.linkedin.javacodechallenges;

import java.util.Random;
import java.util.Scanner;

public class DoubleOrNothing {

    private int startPoints = 10;
    private int userPoints;
    private Scanner scanner = new Scanner(System.in);
    private boolean userIsPlaying = true;
    private Random random = new Random();

    public void playGame() {
        greeting();
        userPoints = startPoints;
        System.out.println("");
        System.out.println("---");
        askToContinue();

        while (this.userIsPlaying) {
            System.out.println("Tossing coin...");
            if (shouldDouble()) {
                doublePoints();
                askToContinue();
            } else {
                loseScreen();
                if (retry()) {
                    userPoints = startPoints;
                } else {
                    userIsPlaying = false;
                    return;
                }
            }
        }
        walkAway();
        return;
    }

    private void greeting() {
        System.out.println("Welome to Double on Nothing! You start with 10 points.");
    }

    private void askToContinue() {
        System.out.println("Would you like to continue playing? if Yes, press Y.");
        userIsPlaying = scanner.nextLine().equalsIgnoreCase("Y");
    }

    private void loseScreen() {
        System.out.println("Game Over. You lost all your points.");
        System.out.println("xxxxxxxxxx");
    }

    private boolean retry() {
        System.out.println("Would you like to retry? if Yes, type Y.");
        return scanner.nextLine().equalsIgnoreCase("Y");
    }

    private void walkAway() {
        System.out.println("Thanks for playing. You finished with " + userPoints + "points.");
    }

    private boolean shouldDouble() {
        return this.random.nextInt(2) == 1;
    }

    private void doublePoints() {
        userPoints = userPoints * 2;
        System.out.println("Congrats! you've doubled your points. You are at " + userPoints + " points.");
    }
}