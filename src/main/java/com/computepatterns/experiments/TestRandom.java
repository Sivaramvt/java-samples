package com.computepatterns.experiments;

import java.util.Random;

/**
 * Created by sivt on 22/06/15.
 */
public class TestRandom {
    public static void main(String args[]){
        Random random = new Random();
        int randomNumber = random.nextInt(8);
        System.out.println(randomNumber);

        Random random1 = new Random();
         int randomNumber1 = random1.nextInt(8);

        System.out.println(randomNumber1);
    }

}
