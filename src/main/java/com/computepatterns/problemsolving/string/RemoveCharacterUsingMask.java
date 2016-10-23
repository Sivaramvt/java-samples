package com.computepatterns.problemsolving.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Remove characters from the input string which are present in the mask string.
 * Complexity - O(m+n). m - size of input string. n - size of mask.
 * @see <a href="http://www.computepatterns.com/problem-solving/string/removing-characters-from-input-string-which-are-present-in-mask-string-java/">
 *     Java code for removing characters from input string based on the mask string.</a>
 */
public class RemoveCharacterUsingMask {

    public String removeCharacters(String input, String mask){

        // Add mask characters in to set.
        Set<Character> maskSet = new HashSet<>();
        for(char c: mask.toCharArray()){
            // Hashset add O(1)
            maskSet.add(c);
        }

        // Loop through input characters and check if it's presnt in mask set.
        List<Character> output = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            // HashSet look up O(1)
            if(!maskSet.contains(input.charAt(i))){
                // List add O(1)
                output.add(input.charAt(i));
            }
        }
        return String.valueOf(output);
    }


    public static void main(String[] args) {
        System.out.printf("Output - %s", new RemoveCharacterUsingMask().removeCharacters("Hello my World!!!", "my!!!"));
    }
}
