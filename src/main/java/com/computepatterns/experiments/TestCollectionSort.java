package com.computepatterns.experiments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by sivt on 18/09/15.
 */
public class TestCollectionSort {

    public static void main(String[] args){

        String[] testArray = {"aa", "bb", "AA", "BB"};
        Collections.sort(Arrays.asList(testArray), new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s1.compareToIgnoreCase(s2);
            }
        });

        System.out.println(Arrays.toString(testArray));
    }
}
