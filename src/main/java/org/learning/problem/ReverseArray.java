package org.learning.problem;

public class ReverseArray {

    public static int[] reverse(int[] arr){
        int rev[] = new int[arr.length];
        int index = 0;
        for(int i= arr.length-1; i>=0; i--) {
            rev[index] = arr[i];
            index = index + 1;
        }
        return rev;
    }

    public static int[] reverse2(int[] arr){ // anoter way of doing
        int start = 0;
        int end = arr.length-1;
        while (start < end)
        {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 2 };

       // int[] rev = reverse(arr);

        int[] rev = reverse2(arr);

        for(int i=0; i<rev.length; i++){
            System.out.print(rev[i]+" ");
        }
    }
}
