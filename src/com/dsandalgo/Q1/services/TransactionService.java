package com.dsandalgo.Q1.services;

public class TransactionService {

    public int targetsAchieved(int[] transactions, int valueOfTarget) {
        // Loop runs only till the total number of transactions are processes (accepted from the user)
        for (int i = 0; i < transactions.length; i++) {
            // If transactions are possible, return the location of where you hit the target
            if (transactions[i] >= valueOfTarget) {
                return i + 1;
            }
            // Reduce from target the currently run transaction (transaction value was
            // accepted from the user)
            else {
                valueOfTarget -= transactions[i];
            }
        }
        // Target was not achieved
        return -1;
    }
}
