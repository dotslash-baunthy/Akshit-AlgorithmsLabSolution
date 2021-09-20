package com.dsandalgo.Q2.main;

import java.util.Scanner;

import com.dsandalgo.Q2.services.FindDenomination;
import com.dsandalgo.Q2.services.MergeSort;

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

        // Enter the value of the notes, each element is a note
        // Do not accept values as 0 or 1
        System.out.print("Enter the currency denomination values: ");
        for (int i = 0; i < numberOfCurrencies; i++) {
            do {
                notes[i] = scanner.nextInt();
                if (notes[i] == 0) {
                    System.out.println("Cannot have a donomination of value 0!");
                } else if (notes[i] == 1) {
                    System.out.println("Cannot have a donomination of value 1!");
                }
            } while (notes[i] < 2);
        }

        // Self explanatory
        System.out.print("Enter the amount you want to pay: ");
        amountToPay = scanner.nextInt();

        // Sort the notes in descending order
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(notes, 0, numberOfCurrencies - 1);

        // Calculate if possible to pay accepted amount using the given currency
        // denominations
        FindDenomination findDenomination = new FindDenomination();
        findDenomination.findMinCombo(notes, amountToPay);

        // Close scanner to prevent memory leak
        scanner.close();
    }
}
