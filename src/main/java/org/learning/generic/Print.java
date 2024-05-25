package org.learning.generic;

public class Print<T extends Number> {
    T value;
    public T getValue(){
        return value;
    }
    public void setPrintValue(T value){
        this.value = value;
    }
    public static void main(String[] args) {
        Print<Float> printObj = new Print<>();
        printObj.setPrintValue(1.0f);
        Float aFloat = printObj.getValue();
        System.out.println(aFloat);
    }
}
