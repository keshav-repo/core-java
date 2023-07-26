package org.learning.trd;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task extends Thread {
    private int taskId;
    public Task(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        super.run();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("executed task: " + taskId);
    }
}

public class ExecutorServiceDemo {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        List<Task> taskList = List.of(new Task(1), new Task(2), new Task(3),
                new Task(4), new Task(5), new Task(6), new Task(7),
                new Task(8));

//        executorService.execute(new Task(1));
//        executorService.execute(new Task(2));
//        executorService.execute(new Task(3));
//        executorService.execute(new Task(4));
//        executorService.execute(new Task(5));
//        executorService.execute(new Task(6));
//        executorService.execute(new Task(7));
//        executorService.execute(new Task(8));
//        executorService.execute(new Task(9));

//        executorService.submit(new Task(1));
//        executorService.submit(new Task(2));
//        executorService.submit(new Task(4));
//        executorService.submit(new Task(3));

        executorService.shutdown();
    }
}
