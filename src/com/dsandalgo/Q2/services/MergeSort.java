package com.dsandalgo.Q2.services;

public class MergeSort {

    public void sort(int[] notes, int low, int high) {
        if (low < high) {

            // Calculate mid
            int mid = (low + high) / 2;

            // Split array into left and right and sort them
            sort(notes, low, mid);
            sort(notes, mid + 1, high);

            // Merge left and right arrays
            merge(notes, low, mid, high);
        }

    }

    private void merge(int[] notes, int low, int mid, int high) {
        int leftArrayLength = mid - low + 1;
        int rightArrayLength = high - mid;

        int[] leftArray = new int[leftArrayLength];
        int[] rightArray = new int[rightArrayLength];

        // Push elements into the left array
        for (int i = 0; i < leftArrayLength; i++) {
            leftArray[i] = notes[low + i];
        }
        // Push elements into the right array
        for (int i = 0; i < rightArrayLength; i++) {
            rightArray[i] = notes[mid + 1 + i];
        }

        int i = 0, j = 0;
        int k = low;

        // Push elements from the left and right arrays in reverse order into a 3rd
        // array (notes[])
        while (i < leftArrayLength && j < rightArrayLength) {
            if (leftArray[i] >= rightArray[j]) {
                notes[k] = leftArray[i++];
            } else {
                notes[k] = rightArray[j++];
            }
            k++;
        }

        // Push remaining elements from the left array into the notes[] array
        while (i < leftArrayLength) {
            notes[k++] = leftArray[i++];
        }

        // Push remaining elements from the right array into the notes[] array
        while (j < rightArrayLength) {
            notes[k++] = rightArray[j++];
        }
    }

}
