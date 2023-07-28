package org.learning.trd;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CallbackWithCompletableFuture {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            // Simulate some computation
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 42;
        });

        // Attach a callback to the CompletableFuture
        future.thenAccept(result -> System.out.println("Callback Result: " + result));

        // Do other tasks here if needed
        System.out.println("Doing other tasks while waiting for the callback...");

        // Block and wait for the CompletableFuture to complete
        future.get();
    }
}
