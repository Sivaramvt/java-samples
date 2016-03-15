package com.computepatterns.bestpractices.accessspecifier;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Static final field pointing to array is not safe as it can be changed outside. Best practice -- Declare a private
 * field and expose it via public field controlling the acces.
 */
public class PublicStaticArrayExample {

    public static void main(String[] args) {
        PublicStaticArrayExample.InnerClass.ARRAY_NO_BEST_PRACTICE[1] = "four";
        System.out.println(Arrays.toString(PublicStaticArrayExample.InnerClass.ARRAY_NO_BEST_PRACTICE));
        System.out.println("Was able to modify the final static field. Loop hole!!! Make it private.");
        System.out.println("\n\n");
        InnerClass.PRIVATE_ARRAY_BEST_PRACTICE[1] = "five";
        InnerClass.ARRAY_BEST_PRACTICE.forEach(System.out::println);
        System.out.println("Cannot modify the array outside the class. Best practice.");
    }

    static class InnerClass {

        // This is declared final but doesn't stop us from changing the array content and hence should be avoided.
        public static final String[] ARRAY_NO_BEST_PRACTICE = {"one", "two", "three"};

        // Solution to the above is to declare a private field and expose it via public field controlling the access.
        private static final String[] PRIVATE_ARRAY_BEST_PRACTICE = {"one", "two", "three"};
        public static final List<String> ARRAY_BEST_PRACTICE = Collections.unmodifiableList(Arrays.asList
                (PRIVATE_ARRAY_BEST_PRACTICE));
    }
}
