package org.learning.trd;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultipleAnyCallable {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<CallableRunner> callableRunnerList = List.of(
                new CallableRunner("in28minutes"),
                new CallableRunner("Ranga"),
                new CallableRunner("Adam")
        );

        String result = executorService.invokeAny(callableRunnerList);

        System.out.println(result);

        executorService.shutdown();
    }
}
