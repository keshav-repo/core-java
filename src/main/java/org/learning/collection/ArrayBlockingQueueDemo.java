package org.learning.collection;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        // Create an ArrayBlockingQueue with a capacity of 10.
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

        // Add some elements to the queue.
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        // Remove some elements from the queue.
        int value1 = queue.take();
        int value2 = queue.take();
        int value3 = queue.take();
        int value4 = queue.take();
        int value5 = queue.take();

        // Print the removed elements.
        System.out.println("The removed elements are: " + value1 + ", " + value2 + ", " + value3 + ", " + value4 + ", " + value5);
    }
}
