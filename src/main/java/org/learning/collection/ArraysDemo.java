package org.learning.collection;

import java.util.Arrays;
import java.util.List;

public class ArraysDemo {
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, -1};

        int findIdx = Arrays.binarySearch(num, 9);
        System.out.println(findIdx);

        Arrays.sort(num);

        int[] newArr = Arrays.copyOf(num, num.length * 2);
        int[] rangeArr = Arrays.copyOfRange(num, 0, 5);

        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        List<Integer> list = Arrays.asList(numbers);

        int[] arr2 = new int[10];
        Arrays.fill(arr2, -1);
        Arrays.stream(arr2).forEach(e -> System.out.print(e + ","));
    }
}
