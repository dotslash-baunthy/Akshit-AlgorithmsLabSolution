package com.dsandalgo.Q1.main;

import java.util.Scanner;

import com.dsandalgo.Q1.services.TransactionService;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeOfTransactionArray;
        int numberOfTargets;
        int valueOfTarget;
        int targetCounter;
        TransactionService transactionService = new TransactionService();

        int[] transactions;

        System.out.print("Enter the size of transaction array: ");
        sizeOfTransactionArray = scanner.nextInt();

        transactions = new int[sizeOfTransactionArray];

        // Each element represents a transaction
        System.out.print("Enter the values of the array: ");
        for (int i = 0; i < sizeOfTransactionArray; i++) {
            transactions[i] = scanner.nextInt();
        }

        System.out.print("Enter the total no. of targets to be achieved: ");
        numberOfTargets = scanner.nextInt();

        for (int i = 0; i < numberOfTargets; i++) {
            // Maximum transaction that can happen in one go
            System.out.print("Enter the value of the targets: ");
            valueOfTarget = scanner.nextInt();

            // Check if it is possible to hit the target in the given transactions and the
            // given transaction values
            targetCounter = transactionService.targetsAchieved(transactions, valueOfTarget);
            if (targetCounter == -1) {
                System.out.println("Target not achieved.");
            } else {
                System.out.println("Target achieved after " + targetCounter + " transactions");
            }
        }
        scanner.close();
    }
}
