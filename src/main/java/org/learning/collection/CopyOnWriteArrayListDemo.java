package org.learning.collection;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.List;

public class CopyOnWriteArrayListDemo {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();

        list.add("Element 1");
        list.add("Element 2");
        list.add("Element 3");

        for(String s: list){
            list.add("more element");
        }
        list.remove(2);

        System.out.println(list);

        Iterator<String> iterator= list.iterator();

        while(iterator.hasNext()){
            iterator.remove();
        }
    }
}
