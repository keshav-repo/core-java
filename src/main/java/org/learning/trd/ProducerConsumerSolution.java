package org.learning.trd;

/*
Producer-Consumer solution using threads in Java
https://www.geeksforgeeks.org/producer-consumer-solution-using-threads-java/?ref=rp
 */

import java.util.LinkedList;

public class ProducerConsumerSolution {

    public static void main(String[] args) throws InterruptedException {

        ProducerConsumer producerConsumer = new ProducerConsumer();

        Thread consumer = new Thread(() -> {
            try {
                producerConsumer.comsume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "consumer");

        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producerConsumer.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "producer");

        consumer.start();
        producer.start();

        consumer.join();
        producer.join();
    }

    public static class ProducerConsumer {
        LinkedList<Integer> list = new LinkedList<>();
        int capacity = 2;

        public void produce() throws InterruptedException {
            int value = 0;
            while (true) {
                synchronized (this) {
                    while (list.size() == capacity) {
                        this.wait();
                    }
                    System.out.println("current Thread: " + Thread.currentThread().getName() + " produced value: " + value);
                    list.add(value++);
                    notify();

                    Thread.sleep(1000);
                }
            }
        }

        public void comsume() throws InterruptedException {
            while (true) {
                synchronized (this) {
                    while (list.size() == 0) {
                        this.wait();
                    }
                    int val = list.removeFirst();
                    System.out.println("current Thread: " + Thread.currentThread().getName() + " consumed value: " + val);

                    notify();
                    Thread.sleep(1000);
                }
            }
        }
    }
}
