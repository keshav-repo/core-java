package org.learning.core;

import java.util.ArrayList;
import java.util.List;

public class PassByValueNonprimitive {

    public static void modify(List<String> stringList){
        System.out.println(stringList.hashCode());
        stringList = new ArrayList<>();
        System.out.println(stringList.hashCode());
        stringList.add("Hello");
    }

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("Hi");

        System.out.println(stringList.hashCode());
        modify(stringList);

        System.out.println(stringList);

    }
}
