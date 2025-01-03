package org.learning.trd;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

// RecursiveTask to calculate the sum of an array using ForkJoin Framework
class SequentialSumTask extends RecursiveTask<Long> {

    private static final int THRESHOLD = 10_000; // Threshold for splitting the task
    private final int[] array;
    private final int start;
    private final int end;

    // Constructor
    public SequentialSumTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        // If the task is small enough, compute sequentially
        if ((end - start) <= THRESHOLD) {
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        } else {
            // Split the task into two subtasks
            int mid = (start + end) / 2;
            SequentialSumTask leftTask = new SequentialSumTask(array, start, mid);
            SequentialSumTask rightTask = new SequentialSumTask(array, mid, end);

            // Fork the subtasks
            leftTask.fork();
            long rightResult = rightTask.compute();
            long leftResult = leftTask.join();

            // Combine the results
            return leftResult + rightResult;
        }
    }
}


public class ForkDemo {

    public static void main(String[] args) {
        // Create a large array of integers
        int size = 100_000;
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1; // Fill the array with values from 1 to size
        }

        // Create a ForkJoinPool
        ForkJoinPool pool = new ForkJoinPool();

        // Create the main task
        SequentialSumTask task = new SequentialSumTask(array, 0, array.length);

        // Start the task and get the result
        long startTime = System.currentTimeMillis();
        long result = pool.invoke(task);
        long endTime = System.currentTimeMillis();

        System.out.println("Sum: " + result);
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
    }
}
