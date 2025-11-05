package com.linkedin.javacodechallenges;

import java.util.Scanner;

public class App {

    public static boolean isPasswordComplex(String password) {
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasNumber = false;

        // Check Length
        if (password.length() > 6) {
            return false;
        }

        // Check for Upper case
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasNumber = true;
            } else if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            }

            if (hasNumber && hasUppercase && hasLowercase) {
                break;
            }
        }

        return hasUppercase && hasLowercase && hasNumber;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a password: ");
        String userInput = scanner.nextLine();
        System.out.println("Is the password complex? "
                + isPasswordComplex(userInput));

        scanner.close();
    }
}
