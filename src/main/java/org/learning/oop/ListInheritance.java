package org.learning.oop;

import java.util.*;

abstract class X {
    public static List<Integer> list;
    public X() {
        list = new ArrayList<>();
    }
}
class Y extends X{
    public Y() {
        super();
    }
}
class Z extends X{
    public Z() {
        super();
    }
}
public class ListInheritance {
    public static void main(String[] args) {
        Y y = new Y();
        Z z = new Z();
        y.list.add(1);
        z.list.add(2);

        System.out.println(y.list);
        System.out.println(z.list);

    }
}
