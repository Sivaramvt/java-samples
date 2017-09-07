package com.computepatterns.datastructures.array;

import java.lang.System;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Experimenting with arrays.
 */
public class ArrayTest {
    public static void main(String[] args) {
        String[] sampleArray = {"One", "Two"};
        String[] copiedArray = new String[sampleArray.length];
        System.arraycopy(sampleArray, 0, copiedArray, 0,sampleArray.length) ;
        System.out.println(Arrays.toString(copiedArray));
        System.out.println(copiedArray.getClass().getName());
        System.out.println(Arrays.stream(sampleArray).filter(x-> x!= "One").collect(Collectors.toList()));
    }
}
