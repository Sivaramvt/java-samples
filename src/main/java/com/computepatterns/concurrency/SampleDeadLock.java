package com.computepatterns.concurrency;

/**
 * 2 threads locking the shared objects and trying to get hold of other lock
 */
public class SampleDeadLock {

    static class SharedResource {
        public void methodA(SharedResource resource) throws InterruptedException {
            synchronized (this) {
                System.out.println(Thread.currentThread().getName());
                resource.methodB(this);
            }
        }

        private void methodB(SharedResource resource) throws InterruptedException {
            synchronized (this) {
                System.out.println(Thread.currentThread().getName());
                resource.methodA(this);
            }
        }
    }

    public static void main(String[] args) {

        SharedResource resource1 = new SharedResource();
        SharedResource resource2 = new SharedResource();
        Thread t1 = new Thread(() -> {
            try {
                resource1.methodA(resource2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.setName("T1");
        Thread t2 = new Thread(() -> {
            try {
                resource2.methodB(resource1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t2.setName("T2");

        t1.start();
        t2.start();
    }
}
