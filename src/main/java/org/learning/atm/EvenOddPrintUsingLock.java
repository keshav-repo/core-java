package org.learning.atm;


import java.util.concurrent.locks.Condition;
        import java.util.concurrent.locks.Lock;
        import java.util.concurrent.locks.ReentrantLock;

public class EvenOddPrintUsingLock {
    private final Lock lock = new ReentrantLock();
    private final Condition evenCondition = lock.newCondition();
    private final Condition oddCondition = lock.newCondition();
    private int count = 1;
    private final int maxCount = 10;

    public void printEven() {
        lock.lock();
        try {
            while (count <= maxCount) {
                while (count % 2 != 0) {
                    evenCondition.await();
                }
                System.out.println(Thread.currentThread().getName() + ": " + count);
                count++;
                oddCondition.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printOdd() {
        lock.lock();
        try {
            while (count <= maxCount) {
                while (count % 2 == 0) {
                    oddCondition.await();
                }
                System.out.println(Thread.currentThread().getName() + ": " + count);
                count++;
                evenCondition.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        EvenOddPrintUsingLock printer = new EvenOddPrintUsingLock();

        Thread evenThread = new Thread(printer::printEven, "EvenThread");
        Thread oddThread = new Thread(printer::printOdd, "OddThread");

        evenThread.start();
        oddThread.start();
    }
}

