package org.learning.strm;

import java.util.ArrayList;
import java.util.Optional;

public class ReductionDemo {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(7);
        arrayList.add(18);
        arrayList.add(10);
        arrayList.add(24);
        arrayList.add(17);
        arrayList.add(5);

        Optional<Integer> productObj = arrayList.parallelStream().reduce((a, b)-> a*b);
        if(productObj.isPresent()){
            System.out.println(productObj.get());
        }

        int product = arrayList.stream().reduce(10, (a,b)-> a*b);
        System.out.println(product);
    }
}
