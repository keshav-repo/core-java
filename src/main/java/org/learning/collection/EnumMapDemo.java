package org.learning.collection;

import java.util.EnumMap;
public class EnumMapDemo {
    public static void main(String[] args) {
        EnumMap<Size, Integer> sizes = new EnumMap<>(Size.class);
        sizes.put(Size.SMALL, 1);
        sizes.put(Size.MEDIUM, 2);
        sizes.put(Size.LARGE, 3);

        int size = sizes.get(Size.MEDIUM);
        System.out.println(size);
    }
    enum Size {
        SMALL, MEDIUM, LARGE
    }
}
