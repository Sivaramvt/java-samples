package com.computepatterns.algorithms.sort;

import java.util.Arrays;

/**
 * Insertion sort - Like sorting a deck of cards. Pick the card from beginning to end one by one and place it in
 * appropriate place in the sorted deck. Time complexity - O(n^2)
 *
 */
public class InsertionSort {

    public int[] sort(int[] elements) {
        // Starting from 1 assuming that first element is sorted.
        for (int i = 1; i < elements.length; i++) {
            // Element to be picked in the right order.
            int key = elements[i];
            // End position of the sorted elements in the array
            int j = i - 1;

            // Continue moving to create a space for the key until the element in sorted portion of array is greater
            // than the key.
            while (j >= 0 && elements[j] > key) {
                elements[j + 1] = elements[j];
                j -= 1;
            }
            // Place the key in the appropriate place.
            elements[j+1] = key;
        }
        return elements;
    }

    public static void main(String[] args) {
        // Elements to be sorted.
        int[] elements = {10, 5, 23, 100, 1, 9, 98};
        System.out.println(Arrays.toString(new InsertionSort().sort(elements)));
    }
}
