package org.learning.atm;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;

public class BlockingQueueExample {

    public static void main(String[] args) {
        // Create a blocking queue with a capacity of 5
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(5);

        // Create a producer thread to add elements to the queue
        Thread producerThread = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    System.out.println("Producing: " + i);
                    blockingQueue.put(i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Create a consumer thread to remove elements from the queue
        Thread consumerThread = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    int value = blockingQueue.take();
                    System.out.println("Consuming: " + value);
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Start both producer and consumer threads
        producerThread.start();
        consumerThread.start();

        // Wait for both threads to finish
        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
