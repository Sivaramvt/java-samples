package com.computepatterns.experiments;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Experimenting the order of instance initialization block
 */
public class InitializationBlockExample {
    private List<String> orderedRelCodeList = Arrays.asList(new String[]{"A", "B", "C"});

    {
        Collections.reverse(orderedRelCodeList);
    }

    public List<String> getOrderedRelCodeList() {
        return orderedRelCodeList;
    }

    public static void main(String[] args) {
        new InitializationBlockExample().getOrderedRelCodeList().forEach(System.out::println);
    }
}
