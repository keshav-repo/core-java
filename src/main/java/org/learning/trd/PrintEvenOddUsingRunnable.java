package org.learning.trd;

/*

 */
public class PrintEvenOddUsingRunnable {

    int counter;
    int n;

    public PrintEvenOddUsingRunnable() {
        counter = 1;
        n = 10;
    }

    public boolean printEven() {
        synchronized (this) {
            while (counter < n) {
                while (counter % 2 == 1) {
                    try {
                        // System.out.println("checking counter: "+counter);
                        wait();
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                        return false;
                    }
                }
                System.out.println(Thread.currentThread().getName() + " : " + counter++ + " ");
                notify();
            }
        }
        return true;
    }

    public boolean printOdd() {
        synchronized (this) {
            while (counter < n) {
                while (counter % 2 == 0) {
                    try {
                        //  System.out.println("checking counter: "+counter);
                        this.wait();
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                        return false;
                    }
                }
                System.out.println(Thread.currentThread().getName() + " : " + counter++ + " ");
                notify();
            }
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName());

        PrintEvenOddUsingRunnable printEvenOdd = new PrintEvenOddUsingRunnable();
        // PrintEvenOdd.n = 10;

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                printEvenOdd.printEven();
            }
        });
        thread.setName("even thread");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                printEvenOdd.printOdd();
            }
        });
        thread2.setName("odd thread");

        thread.start();
        thread2.start();

        //thread.start();
    }
}
