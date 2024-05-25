package org.learning.trd;

import java.util.concurrent.Callable;

public class CallableRunner implements Callable<String> {
    private String name;

    public CallableRunner(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        System.out.println("running with name "+ name);
        return "Hello "+name;
    }
}
