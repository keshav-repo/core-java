package org.learning.misc;

import java.util.Arrays;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        int no[] = new int[5];
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter the first array");

        for (int i = 0; i < no.length; i++) {
            no[i] = s1.nextInt();
        }

        int no_reverse[] = new int[no.length];
        for (int i = 0; i < no.length; i++) {
            no_reverse[i] = no[no.length-i-1];
        }

        System.out.println(Arrays.toString(no));
        System.out.println(Arrays.toString(no_reverse));
    }
}