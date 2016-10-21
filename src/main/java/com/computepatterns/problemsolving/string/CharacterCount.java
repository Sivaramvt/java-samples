package com.computepatterns.problemsolving.string;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;

/**
 * Finding the character count in the given string.
 * Leverages native feature of Apache <code>HashBag</code>
 */
public class CharacterCount {

    public Bag findCharacterCount(String input){
        Bag<Character> characterBag = new HashBag<>();
        char[] characters = input.toCharArray();

        // Finding count is as simple as adding items to bag.
        for (int i = 0; i < characters.length; i++) {
            characterBag.add(new Character(characters[i]));
        }
        return characterBag;
    }

    public static void main(String[] args) {
        // Apache's Bag data structure.
        Bag<Character> bag = new CharacterCount().findCharacterCount("Hello World.");
        bag.uniqueSet().stream().forEach(ch -> {System.out.println(ch + "-" + bag.getCount(ch));});
    }
}
