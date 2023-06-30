package org.learning.collection;

import java.util.EnumSet;

enum Size {
    SMALL, MEDIUM, LARGE, EXTRALARGE
}

public class EnumSetDemo {

    public static void main(String[] args) {
        EnumSet<Size> enumSet = EnumSet.allOf(Size.class);

        System.out.println(enumSet);

    }
}
