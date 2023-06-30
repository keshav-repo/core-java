package org.learning.collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/*
1. merge: example using two map
2. compute: calculate the update price using compute
3.
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        // merge example
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        // Merge the maps
        map2.forEach((key, value) ->
                map1.merge(key, value, (v1, v2) -> v1 + v2)
        );
        // Print the merged map
        System.out.println(map1);


        // COMPUTE EXAMPLE
        HashMap<String, Integer> prices = new HashMap<>();

        // insert entries to the HashMap
        prices.put("Shoes", 200);
        prices.put("Bag", 300);
        prices.put("Pant", 150);
        System.out.println("HashMap: " + prices);

        // recompute the value of Shoes with 10% discount
        int newPrice = prices.compute("Shoes", (key, value) -> value - value * 10/100);
        System.out.println("Discounted Price of Shoes: " + newPrice);

        // print updated HashMap
        System.out.println("Updated HashMap: " + prices);

        System.out.println(prices.computeIfAbsent("ss", k-> 100));

        // REPLACE ALL
        HashMap<Integer, String> languages = new LinkedHashMap<>();

        // add entries to the HashMap
        languages.put(1, "java");
        languages.put(2, "javascript");
        languages.put(3, "python");
        System.out.println("HashMap: " + languages);

        // Change all value to uppercase
        languages.replaceAll((key, value) -> value.toUpperCase());
        System.out.println("Updated HashMap: " + languages);


        // Creating TreeMap of even numbers
        TreeMap<String, Integer> evenNumbers = new TreeMap<>();

        // Using put()
        evenNumbers.put("Two", 2);
        evenNumbers.put("Four", 4);

        // Using putIfAbsent()
        evenNumbers.putIfAbsent("Six", 6);
        System.out.println("TreeMap of even numbers: " + evenNumbers);


    }
}
