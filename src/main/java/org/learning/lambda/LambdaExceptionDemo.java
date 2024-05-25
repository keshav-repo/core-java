package org.learning.lambda;

interface DoubleNumbericArrayFunc{
    double func(double[] n) throws EmptyArrayException;
}

class EmptyArrayException extends Exception{
    public EmptyArrayException() {
        super("Array EMpty");
    }
}

public class LambdaExceptionDemo {
    public static void main(String[] args) throws EmptyArrayException{
        double[] values = {1.0, 2.0, 3.0, 4.0};

        DoubleNumbericArrayFunc average = (n)->{
            double sum = 0;
            if(n.length==0)
                throw new EmptyArrayException();
            for(int i=0; i<n.length; i++){
                sum += n[i];
            }
            return sum/ n.length;
        };

        System.out.println("average is "+ average.func(values));

        System.out.println("average is "+ average.func(new double[0]));
    }
}
