# Java Coding 

### Array:
data structure that stores a fixed-size collection of elements of the same type. Arrays are widely used in Java for storing and manipulating data.

#### Important points
1. declaration and initialisation in different lines
```java
 int[] myArray; // declaration
 myArray = new int[5]; // initialisation
```
2. if we just print the value of array without initialisation, it will give default value of that data type
```java
 for(int i=0; i<myArray.length; i++){
    System.out.println(myArray[i]); // since array type here is int and default value of int is 0
}
```
3. giving some value to array
```java
myArray[0] = 0;
myArray[1] = 1;
myArray[2] = 2;
myArray[3] = 3;
myArray[4] = 4;
```
4. for loop
```java
for(int i=0; i<myArray.length; i++){
    System.out.println(myArray[i]);
} 
```
5. while loop
```java
int x = myArray.length-1;
while (x>-1){
    System.out.println(myArray[myArray.length-1-x]);
    x = x -1;
}
```
6. Declaration and initialization of array in one line
```java
int[] myArray = new int[5];
myArray[0] = 0;
myArray[1] = 1;
myArray[2] = 2;
```
7. Declaration and initialization in one line with values
```java
int[] myArray = new int[]{1, 2, 3, 4, 5};
// for(int i=0; i<myArray.length; i++){
    System.out.println(myArray[i]);
}

// or we can write as 
int[] myArray = {1, 2, 3, 4, 5};
```
7. for-each way of iteration 
```java
for(int item: myArray){
    System.out.println(item);
}
```
8. 
