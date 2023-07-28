package org.learning.trd;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Create a FutureTask with a Callable
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                // Simulate some computation
                Thread.sleep(2000);
                return 42;
            }
        });

        // Create a Thread to run the FutureTask
        Thread thread = new Thread(futureTask);
        thread.start();

        // Do other tasks here while the computation is running...

        // Wait for the result of the computation and retrieve it
        int result = futureTask.get();

        System.out.println("Computation Result: " + result);
    }
}
