package org.learning.misc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class EvenOdd {
    private final int LIMIT;
    private int counter;
    private final Lock lock;
    private final Condition evenCondition;
    private final Condition oddCondition;

    public EvenOdd(int LIMIT) {
        this.LIMIT = LIMIT;
        this.counter = 1;
        lock = new ReentrantLock();
        evenCondition = lock.newCondition();
        oddCondition = lock.newCondition();
    }

    public void printEven() {
        while (counter < LIMIT) {
            lock.lock();
            try {
                while (counter % 2 != 0) {
                    evenCondition.await();
                }
                System.out.println(Thread.currentThread().getName() + " count is: " + counter++);
                oddCondition.signal();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }

    public void printOdd() {
        while (counter < LIMIT) {
            lock.lock();
            try {
                while (counter % 2 == 0) {
                    oddCondition.await();
                }
                System.out.println(Thread.currentThread().getName() + " count is: " + counter++);
                evenCondition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        EvenOdd evenOdd = new EvenOdd(10);

        Thread evenThread = new Thread(evenOdd::printEven, "even thread");
        Thread oddThread = new Thread(evenOdd::printOdd, "odd thread");

        evenThread.start();
        oddThread.start();
    }
}
