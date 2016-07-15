package com.computepatterns.algorithms.search;

import java.util.Arrays;

/**
 * Recursive implementation of binary search. Time complexity - O(Logn).
 *
 * @see <a href="http://quiz.geeksforgeeks.org/binary-search/">Binary Search details.</a>
 */
public class BinarySearch {

    // Returns index of x if it is present in arr[l..r], else
    // return -1

    /**
     * Binary search
     *
     * @param arr           Array to be searched. Assumption - elements are sorted.
     * @param leftPos       Left position in defining scope search space.
     * @param rightPos      Righ position in defining scope search space.
     * @param key Element to be searched.
     * @return
     */
    int binarySearch(int arr[], int leftPos, int rightPos, int key) {

        // Get in as long as the search space is valid.
        if (rightPos >= leftPos) {

            // Finding the mid element.
            int mid = leftPos + (rightPos - leftPos) / 2;

            // If the element is present at the middle itself
            if (arr[mid] == key)
                return mid;

            // If element is smaller than mid, then it can only be present in left sub-array
            if (arr[mid] > key)
                return binarySearch(arr, leftPos, mid - 1, key);

            // Else the element can only be present in right sub-array
            return binarySearch(arr, mid + 1, rightPos, key);
        }

        // We reach here when element is not present in array
        return -1;
    }

    /**
     * Test
     *
     * @param args
     */
    public static void main(String args[]) {

        BinarySearch ob = new BinarySearch();

        // This input array has to be sorted.
        int arr[] = {2, 3, 3, 4, 10, 40};

        // Element to be searched
        int key = 4;

        int result = ob.binarySearch(arr, 0, arr.length - 1, key);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + result);
        
        // JDK's binary search implementation
        int jdkResult = Arrays.binarySearch(arr,key);
        if(-1 == result){
            System.out.println("JDK implementation - Element not found");
        }else{
            System.out.println("JDK implementation - Element at Index:" + jdkResult);
        }
    }
}
