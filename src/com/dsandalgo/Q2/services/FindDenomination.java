package com.dsandalgo.Q2.services;

public class FindDenomination {
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
