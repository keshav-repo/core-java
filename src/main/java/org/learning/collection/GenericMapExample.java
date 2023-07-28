package org.learning.collection;

import java.util.HashMap;
import java.util.Map;

public class GenericMapExample<K, V> {

    private Map<K, V> myMap;

    public GenericMapExample() {
        myMap = new HashMap<>();
    }

    public void putValue(K key, V value) {
        myMap.put(key, value);
    }

    public V getValue(K key) {
        return myMap.get(key);
    }

    public static void main(String[] args) {
        GenericMapExample<String, Integer> intMap = new GenericMapExample<>();
        intMap.putValue("one", 1);
        intMap.putValue("two", 2);
        intMap.putValue("three", 3);

        System.out.println("Value of 'one': " + intMap.getValue("one"));
        System.out.println("Value of 'two': " + intMap.getValue("two"));
        System.out.println("Value of 'three': " + intMap.getValue("three"));

        GenericMapExample<String, String> stringMap = new GenericMapExample<>();
        stringMap.putValue("name", "John");
        stringMap.putValue("age", "30");

        System.out.println("Name: " + stringMap.getValue("name"));
        System.out.println("Age: " + stringMap.getValue("age"));
    }
}
