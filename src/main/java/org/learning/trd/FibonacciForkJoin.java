package org.learning.trd;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class Fibonacci extends RecursiveTask<Long> {

    private final long n;

    Fibonacci(long n) {
        this.n = n;
    }

    @Override
    protected Long compute() {
        if (n <= 1)
            return n;

        Fibonacci f1 = new Fibonacci(n - 1);
        f1.fork();

        Fibonacci f2 = new Fibonacci(n - 2);
        return f2.compute() + f1.join();
    }
}

public class FibonacciForkJoin {
    public static void main(String[] args) {
        int processorCount = Runtime.getRuntime().availableProcessors();
        System.out.println("Processor count "+ processorCount);

        ForkJoinPool forkJoinPool = new ForkJoinPool();

        System.out.println("Default pool size: " + ForkJoinPool.commonPool().getParallelism());

        Fibonacci fibonacci = new Fibonacci(25);

        long res = forkJoinPool.invoke(fibonacci);
        System.out.println(res);
    }
}
