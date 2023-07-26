package org.learning.atm;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    private final Lock lock = new ReentrantLock();

    public void performTask() {
        lock.lock();
        try {
            // Critical section - the code that requires exclusive access
            System.out.println("Thread " + Thread.currentThread().getId() + " is performing the task.");
            // Simulate some work being done
            Thread.sleep(1000);
            System.out.println("Thread " + Thread.currentThread().getId() + " completed the task.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockExample example = new ReentrantLockExample();

        // Create multiple threads to simulate concurrent access
        Thread thread1 = new Thread(example::performTask);
        Thread thread2 = new Thread(example::performTask);

        // Start the threads
        thread1.start();
        thread2.start();

        // Wait for both threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
