package org.learning.strm;

import java.util.ArrayList;

public class AccumulatorCombinerDemo {
    public static void main(String[] args) {
        ArrayList<Double> arrayList = new ArrayList<>();
        arrayList.add(4.0);
        arrayList.add(9.0);
        arrayList.add(10.0);
        arrayList.add(24.0);
        arrayList.add(17.0);
        arrayList.add(5.0);

        double productOfSquareRoot = arrayList.parallelStream().reduce(1.0, (a,b)->{
                    System.out.println("in accumalator a "+ a +" b= "+b);
                    return a*Math.sqrt(b);
                },
                (a,b)->{
                    System.out.println("in combiner a= "+a +" b="+b);
                    return a*b;
                });
        System.out.println(productOfSquareRoot);
    }
}
