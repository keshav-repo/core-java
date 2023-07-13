package org.learning.str;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class StringDemo {
    public static void main(String[] args) {
//        String str1 = "Hello";
//      //  str1 = str1 +"World";
//
//        String str2 = new String("Hello");
//        String str3 = new String("Hello").intern();
//
//        System.out.println(str3);

//        System.out.println(str1.hashCode());
//        System.out.println(str2.hashCode());
//        System.out.println(str1.equals(str2));
//
//        System.out.println(str2.equals(str3));
//        String str4 = "Hello";
//        System.out.println(str1 == str4 );


//        StringBuffer stringBuffer = new StringBuffer("Hello");
//        stringBuffer.append(", World!"); // Appends ", World!" to the existing content
//        stringBuffer.insert(5, " Java"); // Inserts " Java" at index 5
//        System.out.println(stringBuffer.toString());
//
//        String str1=new String("Scaler");
//        String str2=new String("Scaler");
//
//        System.out.println(str1);
//        System.out.println(str2.hashCode());
//
//        System.out.println(str1 == str2);
//        System.out.println(str1.equals(str2));

//        String str = "Hello World";
//        CharSequence charSequence = str.subSequence(0, str.length());

//        String str = "Hello world";
//        byte[] byteArray = str.getBytes();
//        // print the byte[] elements
//        System.out.println("String to byte array: " + Arrays.toString(byteArray));
//
//        String stringFrimByte = new String(byteArray, StandardCharsets.UTF_8).intern();
//        System.out.println(stringFrimByte);

        String str1 = new String("interviewbit");
        String str2 = new String("INTERVIEWBIT");
        System.out.println(str1 = str2);


    }
}
