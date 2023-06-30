package org.learning.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class SynchronizedListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.addAll(List.of("A", "B", "C", "D", "E"));
        List<String> synlist = Collections.synchronizedList(list);
        System.out.println("Synchronized list is : " + synlist);
    }
}
