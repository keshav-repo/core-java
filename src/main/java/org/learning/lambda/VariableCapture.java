package org.learning.lambda;

interface MyFunc{
    int func(int n);
}

public class VariableCapture {
    public static void main(String[] args) {
        int num = 10;
        MyFunc myFunc = (n)->{
           // int v = num+n;
           // num++; // local variables referenced from a lambda expression must be final or effectively final
            return n;
        };
    }
}
