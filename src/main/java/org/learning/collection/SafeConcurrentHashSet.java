package org.learning.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class SafeConcurrentHashSet {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Boolean> map = new ConcurrentHashMap<>();

        Set<String> concurrentMap = map.newKeySet();

        concurrentMap.add("456");
        concurrentMap.add("789");
        concurrentMap.add("101112");


        Thread thread1 = new Thread(()->{
            System.out.println("I "+concurrentMap);
            concurrentMap.add("Hello");
            concurrentMap.add("world");
            concurrentMap.add("123");
            System.out.println("II "+concurrentMap);
        });
        Thread thread2 = new Thread(()->{
            System.out.println("III "+concurrentMap);
            concurrentMap.add("456");
            concurrentMap.add("789");
            concurrentMap.add("101112");
            System.out.println("IV "+concurrentMap);
        });

        thread2.start();
        thread1.start();


//        // Create the ConcurrentHashMap
//        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
//
//// Create the set by newKeySet() method of ConcurrentHashMap
//        Set<String> set = map.newKeySet();
//
//// add() method
//        set.add("geeksforgeeks");
//        set.add("geeks");
//
//// contains() method to check whether the element present or
//// not it will return boolean value (true or false)
//        set.contains("geeks");
//
//// remove() method to remove an element from set
//        set.remove("geeksforgeeks");


    }
}
