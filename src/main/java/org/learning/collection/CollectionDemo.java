package org.learning.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(10);
        list.add("Hello");
        list.add("World");
        list.add("Program");
        list.add("to");
        list.add("get");
        list.add("simple interest");

        Iterator<String> iterator  = list.iterator();
        while (iterator.hasNext()){
           String w =  iterator.next();
            if(w.equals("Hello")){
                iterator.remove();
            }
//            System.out.println(w);
        }
        System.out.println(list);


    }
}
