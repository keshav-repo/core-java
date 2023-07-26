package org.learning.trd;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultipleCallableRunner {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<CallableRunner> callableRunnerList = List.of(
                new CallableRunner("in28minutes"),
                new CallableRunner("Ranga"),
                new CallableRunner("Adam")
        );


        List<Future<String>> futureList = executorService.invokeAll(callableRunnerList);

        futureList.stream().forEach(future->{

        });

//        List<Future<String>> results = executorService.invokeAll(callableRunnerList);
//        for(Future<String> result: results){
//            System.out.println(result.get());
//        }


        executorService.shutdown();

    }
}
