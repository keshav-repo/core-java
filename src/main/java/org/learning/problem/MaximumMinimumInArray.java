package org.learning.problem;

public class MaximumMinimumInArray {

    public static int getMaximum(int[] arr) {
        int max = arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }

    public static int getMinimum(int[] arr) {
        int min = arr[0];
        for(int i=1; i<arr.length; i++){
            if(min>arr[i]){
                min = arr[i];
            }
        }
        return min;
    }


    public static void main(String[] args) {
        int a[] = { 1, 423, 6, 46, 34, 23, 13, 53, 4 };

        System.out.println(getMaximum(a));

        System.out.println(getMinimum(a));

    }
}
