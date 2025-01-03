package org.learning.collection;

import java.util.Map;
import java.util.concurrent.*;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {

        Map<String, Integer> map = new ConcurrentHashMap<>();

        Runnable runnable = () -> {
            String thread = Thread.currentThread().getName();
            for(int i=0; i<10; i++) {
                map.compute(thread, (key, value) -> (value == null) ? 1 : value + 1);
                System.out.println("updated map " + map + "in thread "+ thread);
            }
        };
        Thread thread1 = new Thread(runnable, "thread-1");
        Thread thread2 = new Thread(runnable, "thread-2");

        thread1.start();
        thread2.start();

        try{
            thread1.join();
            thread2.join();
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("map "+map);
    }
}
