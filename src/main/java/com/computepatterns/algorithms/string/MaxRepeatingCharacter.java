package com.computepatterns.algorithms.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Finding the maximum repeating character in a string
 * Time complexity - O(n) Linear time.
 * Insertion and getting value from map is O(1) constant time and hence doesn't impact.
 */
public class MaxRepeatingCharacter {

    public void findMaxRepeatingCharacter(String input){
        // To keep track of max char and its count.
        Character maxChar = Character.MIN_VALUE;
        int maxCharCount=0;

        // Map to bucketize the characters.
        Map<Character,Integer> characterMap = new HashMap<>();

        // Single loop to bucketize and keep track of the max char.
        char[] charArray = input.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            Character tempChar = charArray[i];

            // If the character is already present in the map.
            if(characterMap.containsKey(tempChar)){
                characterMap.put(tempChar, characterMap.get(tempChar) + 1);
                if(characterMap.get(tempChar) > maxCharCount){
                    maxCharCount = characterMap.get(tempChar);
                    maxChar = tempChar;
                }
            }else{ //If the character is new to the map.
                characterMap.put(tempChar, 1);
                if(maxCharCount == 0){
                    maxCharCount++;
                    maxChar = tempChar;
                }
            }
        }

        System.out.println("Max char - " + maxChar.toString() + " with count - " + maxCharCount);
    }

    public static void main(String[] args) {
       new MaxRepeatingCharacter().findMaxRepeatingCharacter("Hello World£££.");
    }
}
