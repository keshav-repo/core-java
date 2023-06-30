package org.learning.collection;

import java.util.concurrent.atomic.AtomicInteger;

public class AtmoicIntDemo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(10);
        atomicInteger.set(50);
        atomicInteger.lazySet(100);
        atomicInteger.compareAndSet(100, 101);
        atomicInteger.decrementAndGet();
    }
}
