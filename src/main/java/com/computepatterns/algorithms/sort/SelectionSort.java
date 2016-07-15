package com.computepatterns.algorithms.sort;

import java.util.Arrays;

/**
 * Selection sort - Minimum data element from the unsorted array has been selected and swapped with the first element of
 * the unsorted array. Time complexity - O(n^2) as it involves 2 loop.
 */
public class SelectionSort {
    /**
     * Selection sort.
     * @param elements
     */
    void sort(int[] elements) {

        // Complexity - Loop 1
        for (int i = 0; i < elements.length; i++) {

            // Complexity - Loop 2.
            // Finding minimum in the unsorted portion.
            int minValueIndex = i;
            for (int j = i; j < elements.length; j++) {
                if(elements[j] < elements[minValueIndex]){
                    minValueIndex = j;
                }
            }

            // Swapping the minimum value with the first value in the unsorted array.
            int valueToSwap = elements[i];
            elements[i] = elements[minValueIndex];
            elements[minValueIndex] = valueToSwap;
        }
    }

    public static void main(String[] args) {
        int[] elements = {10,30, 20, 100, 50};
        new SelectionSort().sort(elements);
        System.out.println(Arrays.toString(elements));
    }
}
