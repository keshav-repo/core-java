package org.learning.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();

        integerList.add(10);
        integerList.add(20);
        integerList.add(30);

//        for (int val : integerList) {
//            integerList.add(40);
//            System.out.println(val);
//        }

        Iterator<Integer> integerIterator = integerList.iterator();

        while (integerIterator.hasNext()) {
            int n = integerIterator.next();
           // System.out.println(n);
            if (n == 10) {
                integerIterator.remove();
            }
        }
        System.out.println(integerList);


    }
}
