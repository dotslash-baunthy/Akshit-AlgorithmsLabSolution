package com.dsandalgo.Q2.main;

import java.util.Scanner;

import com.dsandalgo.Q2.services.ProcessDenominations;
import com.dsandalgo.Q2.services.ReverseSort;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCurrencies;
        int[] notes;
        int amountToPay;

        // Accept number of notes from the user
        System.out.print("Enter the size of the denominations: ");
        numberOfCurrencies = scanner.nextInt();

        // Give notes array a size = number of notes
        notes = new int[numberOfCurrencies];

        ProcessDenominations processDenominations = new ProcessDenominations();

        // Enter the value of the notes, each element is a note
        // Do not accept values as 0 or 1
        notes = processDenominations.input(notes);

        // Self explanatory
        System.out.print("Enter the amount you want to pay: ");
        amountToPay = scanner.nextInt();

        // Sort the notes in descending order
        ReverseSort reverseSort = new ReverseSort();
        notes = reverseSort.sort(notes, 0, numberOfCurrencies - 1);

        // Calculate if possible to pay accepted amount using the given currency
        // denominations
        processDenominations.findMinCombo(notes, amountToPay);

        // Close scanner to prevent memory leak
        scanner.close();
    }
}
