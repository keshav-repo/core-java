package org.learning.trd;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Print implements Callable<Void> {

    private int start;
    private int end;
    private boolean isEven;

    public Print(int start, int end, boolean isEven) {
        this.start = start;
        this.end = end;
        this.isEven = isEven;
    }

    @Override
    public Void call() throws Exception {
        for (int i = start; i <= end; i++) {
            if ((isEven && (i % 2 == 0)) || (!isEven && (i % 2 == 1)))
                System.out.println(Thread.currentThread().getName() + " value is " + i);
        }
        return null;
    }
}

public class PrintEvenOdd {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        int start = 1;
        int end = 20;

        Print even = new Print(start, end, true);
        Future<Void> printEven = executorService.submit(even);
        Future<Void> printOdd = executorService.submit(new Print(start, end, false));

        try {
            printEven.get();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        executorService.shutdown();
    }
}
