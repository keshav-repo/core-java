package org.learning.collection;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedListQueueExample {
    public static void main(String[] args) {
        // Create a LinkedList to use as a queue
        Queue<String> queue = new LinkedList<>();

        // Add elements to the queue
        queue.add("Element 1");
        queue.add("Element 2");
        queue.add("Element 3");

        // Remove and retrieve elements from the queue
        String firstElement = queue.remove();
        String secondElement = queue.poll();

        // Get the element at the front of the queue without removing it
        String peekedElement = queue.peek();

        // Print the elements
        System.out.println("First Element: " + firstElement);
        System.out.println("Second Element: " + secondElement);
        System.out.println("Peeked Element: " + peekedElement);
    }
}
