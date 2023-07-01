package org.learning.strm;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class ParallelComputingExample {
    public static void main(String[] args) {


        int sumOfSquares = IntStream.range(1, 1_000_000)
                .parallel()
                .map(n-> n*n)
                .reduce(0, Integer::sum);
        System.out.println(sumOfSquares);


        int[] array = new int[1_000_000];
        Random random = new Random();
        for(int i=0; i<array.length; i++){
            array[i] = random.nextInt(101);
        }

        long startTime = System.currentTimeMillis();

        int sumOfArrayEle = Arrays.stream(array)
                .parallel()
                .sum();

        System.out.println(sumOfArrayEle);
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Time elapsed: " + elapsedTime + " milliseconds");

    }
}
