package org.learning.collection;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        Queue<String> stringQueue = new PriorityQueue<>();

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        // Add some elements to the queue
        queue.add(10);
        queue.add(5);
        queue.add(15);
        queue.add(2);
        queue.add(7);

        // Print the elements in the queue
        System.out.println("Elements in the queue:");
        for (int i : queue) {
            System.out.println(i);
        }

        // Remove the head of the queue
        while (!queue.isEmpty()){
            int head = queue.poll();
            System.out.println("Head of the queue: " + head);
        }

        // Check if the queue is empty
        boolean isEmpty = queue.isEmpty();
        System.out.println("Is the queue empty? " + isEmpty);
    }
}
