package com.computepatterns.java8.lambda.obe;

/**
 * This example uses lambda to create a new thread
 */
public class RunnableLambdaTest {
    public static void main(String[] args) {

        // Using the anonymous inner class.
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread created and run using anonymous inner class.");
            }
        };
        new Thread(task).start();

        // Using lambda
        new Thread(() -> {
            System.out.println("Thread created and run using the lambda construct.");
        }).start();
    }
}
