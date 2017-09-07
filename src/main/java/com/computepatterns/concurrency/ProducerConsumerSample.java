package com.computepatterns.concurrency;

import java.util.Deque;
import java.util.LinkedList;

/**
 * TODO - Wait / notify work on the same object.
 * https://stackoverflow.com/questions/2536692/a-simple-scenario-using-wait-and-notify-in-java
 * https://docs.oracle.com/javase/tutorial/essential/concurrency/guardmeth.html
 */
public class ProducerConsumerSample {
    static class Producer{
        public void produce(Deque<String> queue){
            do{
                synchronized (queue) {
                    queue.offer("msg");
                    System.out.println("Message inserted");
                    queue.notifyAll();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }while(true);
        }
    }

    static class Consumer{
        public void consume(Deque<String> queue){
            do{
                synchronized (queue) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Message polled - " + queue.poll());
                }
            }while(true);
        }
    }

    public static void main(String[] args) {
        Deque<String> queue = new LinkedList<>();
        Thread producer = new Thread(()->{new Producer().produce(queue);});
        producer.start();

        Thread consumer = new Thread(()->{new Consumer().consume(queue);});
        consumer.start();
    }
}
