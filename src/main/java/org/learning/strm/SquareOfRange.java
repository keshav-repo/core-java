package org.learning.strm;

import java.util.Arrays;

public class SquareOfRange {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Perform a computation on the numbers using parallel stream
        int sum = Arrays.stream(numbers)
                .parallel()
                .map(SquareOfRange::compute)
                .sum();

        System.out.println("Sum: " + sum);

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        System.out.println("Time elapsed: " + elapsedTime + " milliseconds");
    }

    public static int compute(int number) {
        // Simulate a time-consuming computation
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Return the square of the number
        return number * number;
    }
}
