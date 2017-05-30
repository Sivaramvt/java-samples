package com.computepatterns.algorithms.sort;

import java.util.Arrays;

/**
 * Heap sort implementation.
 * As heap is complete binary tree, it can be expressed as array.
 * Time complexity worst case - O(nlogn).
 */
public class HeapSort
{
    public static void main(String args[])
    {
        int inputArray[] = {15, 1, 14, 50, 6, 70, 8};
        new HeapSort().sort(inputArray);
        System.out.println("Sorted array - ");
        System.out.println(Arrays.toString(inputArray));
    }

    public void sort(int inputArray[])
    {
        /* Build max heap. */
        // Doing it for half the array is sufficient as the rest of array are going the children nodes.
        for (int i =  inputArray.length/ 2 - 1; i >= 0; i--){
            heapify(inputArray, inputArray.length, i);
        }

        /* Extract the biggest element (top of heap) one by one and move to the end */
        for (int i = inputArray.length - 1; i>=0; i--)
        {
            // Move current root to end
            int temp = inputArray[0];
            inputArray[0] = inputArray[i];
            inputArray[i] = temp;

            // Call max heapify on the reduced heap.
            heapify(inputArray, i, 0);
        }
    }

    /**
     * Heapify builds the heap ensuring heap conditions are taken care.
     * @param arr Input array to sort
     * @param arrayLength Length of the array to be considered.
     * @param rootElementIndex
     */
    void heapify(int arr[], int arrayLength, int rootElementIndex)
    {
        /* Find out the left and right children */
        int leftIndex = 2*rootElementIndex + 1;  // left = 2*i + 1
        int rightIndex = 2*rootElementIndex + 2;  // right = 2*i + 2

        /* Find out the largest of left, root, right */
        // Assume the root element is largest
        int largest = rootElementIndex;
        // If left child is larger than root
        if (leftIndex < arrayLength && arr[leftIndex] > arr[largest])
            largest = leftIndex;
        // If right child is larger than largest so far
        if (rightIndex < arrayLength && arr[rightIndex] > arr[largest])
            largest = rightIndex;

        /* Get the heap right if root is not the largest */
        if (largest != rootElementIndex)
        {
            // Swap the largest with the root.
            int swap = arr[rootElementIndex];
            arr[rootElementIndex] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, arrayLength, largest);
        }
    }
}