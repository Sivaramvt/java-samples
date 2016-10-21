package com.computepatterns.problemsolving.string;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Remove duplicates from the given String.
 * Leverage JDK set. Set doesn't allow duplicates.
 */
public class RemoveDuplicates {

    String removeDuplicates(String input){
        // LinkedHashSet over HashSet as LinkedHashSet preserve order.
        // Set doesn't allow duplicates.
        Set<Character> characterSet = new LinkedHashSet<Character>();

        for (int i = 0; i < input.length(); i++) {
            if(!characterSet.add(input.charAt(i))){
                System.out.printf("Duplicate character - %c\n", input.charAt(i));
            };
        }
        return characterSet.toString();
    }

    public static void main(String[] args) {

        String output = new RemoveDuplicates().removeDuplicates("Hello World!!!");
        System.out.printf("String after removing duplicates - %s", output);
    }
}
