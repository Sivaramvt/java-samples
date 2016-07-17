package com.computepatterns.algorithms.sort;

import java.util.Arrays;

/**
 * Simplest form of sorting. Swaps adjacent elements in multiple passes until all the elements are sorted. Time
 * complexity - O(n^2) as it involves 2 loops
 *
 * @see <a href="http://quiz.geeksforgeeks.org/bubble-sort/">Bubble Sort</a>
 */
public class BubbleSort {

    void sort(int[] elements) {
        // Loop # 1 - O(n)
        for (int i = 0; i < elements.length - 1; i++) {
            boolean isSwapHappened = false;
            // Loop #2 - O(n) and total O(n^2)
            for (int j = 0; j < elements.length - i - 1; j++) {

                // for (int j = 0; j < elements.length - i - 1 ; j++) { Theoretically, this is also fine.
                if (elements[j] > elements[j + 1]) {
                    int swap = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = swap;

                    isSwapHappened = true;
                }
            }

            // If no swap happened in the pass, exit
            if (!isSwapHappened) {
                System.out.println("Swap didn't happen");
                return;
            }
        }
    }

    public static void main(String[] args) {
        int[] elements = new int[]{64, 25, 12, 22, 11, 10, 9, 8, 21};
        new BubbleSort().sort(elements);

        System.out.println(Arrays.toString(elements));
    }
}
