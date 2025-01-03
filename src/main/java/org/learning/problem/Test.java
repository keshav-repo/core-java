package org.learning.problem;

import java.util.concurrent.RecursiveAction;

class SimpleRecursiveAction extends RecursiveAction {
    private int simulatedWork;
    public SimpleRecursiveAction(int simulatedWork) {
        this.simulatedWork = simulatedWork;
    }
    @Override
    protected void compute() {
        // if the task is too large then we split it and execute the tasks in parallel
        if (simulatedWork > 100) {

            System.out.println("Parallel execution and split the tasks..." + simulatedWork);

            SimpleRecursiveAction action1 = new SimpleRecursiveAction(simulatedWork / 2);
            SimpleRecursiveAction action2 = new SimpleRecursiveAction(simulatedWork / 2);

            invokeAll(action1, action2);
        } else {
            System.out.println("The task is rather small so sequential execution is fine ... ");
            System.out.println("The size of the task: " + simulatedWork);
        }
    }
}

public class Test {
    public static void main(String[] args) {
        // ForkJoinPool pool = new ForkJoinPool();
        SimpleRecursiveAction action = new SimpleRecursiveAction(800);
        action.invoke();
    }
}
