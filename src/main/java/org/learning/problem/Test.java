package org.learning.problem;

/*
In a array of 4 size store four values in it from human input and consider those 4 values are the 4 length of the rectangle.
Please a logic to find out the area for the same[write the program in eclipse and copy paste the program here]
 */

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        int[] myArray = new int[4];
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<4; i++){
            myArray[i] = sc.nextInt();
        }
        int area = myArray[0]*myArray[1];
        System.out.println(area);
    }
}
