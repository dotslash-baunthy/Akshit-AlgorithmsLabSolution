package com.dsandalgo.Q2.services;

import java.util.Scanner;

public class ProcessDenominations {

    // Function to input the currency
    public int[] input(int[] notes) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the currency denomination values: ");
        for (int i = 0; i < notes.length; i++) {
            notes[i] = scanner.nextInt();
            // Throw exception in case the entered denomination is 0 or less than it
            if (notes[i] <= 0) {
                throw new ArithmeticException("Cannot have a currency with denomination 0 or less");
            }
            // Throw exception in case entered denomination is 1
            else if (notes[i] == 1) {
                throw new ArithmeticException("The amount can be paid with notes of denomination 1");
            }
        }

        return notes;
    }

    public void findMinCombo(int[] notes, int amountToPay) {
        int[] numberOfDenominations = new int[notes.length];
        for (int i = 0; i < notes.length; i++) {
            // Modulo operator to calculate if the remaining money can be paid using the
            // given denominations
            // Each element is a denomination
            if (amountToPay != 0) {
                // Exception handling to check for division by 0. This will never run since 0 is
                // not accepted as a denomination in the Driver but it doesn't hurt to add a
                // check
                try {
                    numberOfDenominations[i] = amountToPay / notes[i];
                } catch (ArithmeticException e) {
                    System.out.println("Exception: " + e + ". Ending program.");
                    System.exit(0);
                }
                amountToPay %= notes[i];
            }
        }

        // If an amount is left to pay, print that payment is not possible
        if (amountToPay > 0) {
            System.out.println("Not possible to pay.");
        }

        // Print the value of a note (notes[i]) and how many notes will be needed
        // (numberOfDenominations[i])
        else {
            for (int i = 0; i < notes.length; i++) {
                if (numberOfDenominations[i] != 0) {
                    System.out.println(notes[i] + ":" + numberOfDenominations[i]);
                }
            }
        }
    }
}
