package com.computepatterns.problemsolving.string;

/**
 * Permutation of a string.
 * Algorithm uses recursion.
 * Number of permuted items - Factorial of (length of string).
 * Example - Permutations of ABC is [ABC, ACB, BAC, BCA, CAB, CBA]
 * Time complexity - O(n*n!) - n for printing the output and n! for the recursion.
 *
 * Example of how it works - <a href="http://d1gjlxt8vb0knt.cloudfront.net//wp-content/uploads/NewPermutation.gif">GeekforGeeks</a>
 * @See <a href="http://www.computepatterns.com/problem-solving/string/printing-permutations-of-a-string-in-java/">Details at computepatterns.com</a>
 */
public class Permutation {

    public void permute(String input){
        permute("", input);
    }

    private void permute(String prefix, String suffix){
        if(1 == suffix.length()){
            System.out.println(prefix + suffix);
        }else {
            for (int i = 0; i < suffix.length(); i++) {
                permute(prefix + suffix.charAt(i), suffix.substring(0,i) + suffix.substring(i+1, suffix.length()));
            }
        }
    }

    public static void main(String[] args) {
        new Permutation().permute("ABC");
    }
}
