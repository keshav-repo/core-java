package org.learning.collection;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class CollectionsMethodDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(9);
        list.add(54);
        list.add(66);
        list.add(76);
        list.add(12);
        list.add(34);

        Collections.sort(list);
        System.out.println(list);

        int idx = Collections.binarySearch(list, 34);
        System.out.println(idx);

        List<Integer> list2 = new ArrayList<>();
        list2.add(90);
        list2.add(12);
        list2.add(98);
        list2.add(43);

        Collections.copy(list, list2);
        System.out.println(list);

        Collections.fill(list2, 0);
        System.out.println(list2);

        System.out.println(Collections.min(list));
        System.out.println(Collections.frequency(list, 12));
    }
}
