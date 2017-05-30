package com.computepatterns.experiments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Double brace initialization should generally be avoided. Syntax is non-idiomatic. Create additional inner class.
 */
public class DoubleBraceInitialization {
    public static void main(String[] args) {
        final List<String> testList = new ArrayList<String>() {
            {
                // This one is an anonymous inner class  which has access to the outer class via 'this' pointer.
                add("One");
                add("Two");
            }
        };
        System.out.println(Arrays.toString(testList.toArray()));
    }
}
