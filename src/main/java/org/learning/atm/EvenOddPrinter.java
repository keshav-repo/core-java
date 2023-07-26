package org.learning.atm;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class EvenOddPrinter {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private int count = 1;
    private final int maxCount = 10;

    public void printNumber(boolean isEven) {
        lock.lock();
        try {
            while (count <= maxCount) {
                if ((count % 2 == 0) == isEven) {
                    System.out.println(Thread.currentThread().getName() + ": " + count);
                    count++;
                    condition.signal();
                } else {
                    condition.await();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        EvenOddPrinter printer = new EvenOddPrinter();

        Thread evenThread = new Thread(() -> printer.printNumber(true), "EvenThread");
        Thread oddThread = new Thread(() -> printer.printNumber(false), "OddThread");

        evenThread.start();
        oddThread.start();
    }
}
