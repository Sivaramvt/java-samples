package com.computepatterns.datastructures.array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Count the number of positive values, negative values and zeros. Print their proportions.
 */
public class IntegerArrayCounting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /* Accept the numbers using scanner */
        int size = Integer.parseInt(scanner.nextLine());
        /* Convert the input into integer array */
        String[] inputTokens = scanner.nextLine().split(" ");
        int[] input = Arrays.stream(inputTokens).mapToInt(Integer::parseInt).toArray();
        /* Native - Bucketize the array into 3 taking count of each. Complexity O(n)*/
        int positiveValues = 0;
        int zeroValues = 0;
        int negativeValues = 0;
        for (int value : input) {
            if (value > 0) {
                positiveValues++;
            } else if (value < 0) {
                negativeValues++;
            } else {
                zeroValues++;
            }

        }
        /* Print the results */
        System.out.printf("%f%n", (double)positiveValues / (double)size);
        System.out.printf("%f%n", (double)negativeValues / (double)size);
        System.out.printf("%f", (double)zeroValues / (double)size);
    }
}
