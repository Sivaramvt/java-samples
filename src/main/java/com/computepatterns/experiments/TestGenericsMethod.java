package com.computepatterns.experiments;



/**
 * Created by sivt on 30/07/15.
 */
public class TestGenericsMethod {

    public static <T> String getLMAssetService(Class<T> serviceType){
        System.out.println("Hello.");
        return "test";

    }

    public static void main(String[] args){
        String test = TestGenericsMethod.getLMAssetService(String.class);
    }

}
