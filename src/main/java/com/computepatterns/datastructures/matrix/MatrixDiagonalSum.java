package com.computepatterns.datastructures.matrix;

import java.util.Scanner;

/**
 * Compute absolute difference between the sum of diognal elements in an 2D square matrix
 */
public class MatrixDiagonalSum {
    public static int computeDiagonalSum(int input[][], int size) {
        /* Get the sum of first diagonal */
        int dialognoal1Sum = 0;

        int diagonal2Ptr = size - 1;
        int dialognoal2Sum = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    dialognoal1Sum += input[i][j];
                }

                if (diagonal2Ptr == j) {
                    dialognoal2Sum += input[i][diagonal2Ptr];
                    diagonal2Ptr--;
                }
            }
        }

        return Math.abs(dialognoal1Sum - dialognoal2Sum);

    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        if (n > 100 || n < -100) {
            System.out.println("Input number not valid.");
        }

        int[][] input = new int[n][n];
        for (int i = 0; i < n; i++) {
            String inputLine = scanner.nextLine();
            int j = 0;
            for (String token : inputLine.split(" ")) {
                input[i][j] = Integer.parseInt(token);
                j++;
            }
        }

        System.out.print(computeDiagonalSum(input, n));
    }
}
