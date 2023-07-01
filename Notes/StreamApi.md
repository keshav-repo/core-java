# Concept 

### 1. Collector class main method and its working ?
- The Collectors.groupingBy() method in Java is a powerful collector that allows you to group elements of a stream based on a classification function. It collects the elements into a Map where the keys are the distinct groups and the values are the elements belonging to each group.
```
Collector<T, ?, Map<K, D>> groupingBy(Function<? super T, ? extends K> classifier,
                                          Collector<? super T, A, D> downstream)
```
- Different type of grouping:
   - Grouping by a Property:
   - Grouping by a Calculation Result:
   - Grouping and Counting:
   - Grouping and Summing:
- **Collectors.mapping**: The Collectors.mapping() method is a powerful collector provided by the Stream API in Java. It is used to transform the elements of a stream using a mapping function and collect the transformed elements into a collection or perform further operations on them.

### 2. map in stream: 
The map() operation is used to transform the elements of a stream by applying a given function to each element. It takes a lambda expression or method reference as an argument, which defines the transformation to be applied. The map() operation returns a new stream consisting of the transformed elements.
```
<R> Stream<R> map(Function<? super T, ? extends R> mapper);
```
### 3. **distinct()**:  
 Operation is used to eliminate duplicate elements from a stream. It returns a new stream containing only the unique elements based on their natural order or the equality defined by the equals() method.

The time complexity of distinct() can vary depending on the size of the stream and the nature of the elements being compared. If the stream has n elements and the comparison of elements takes constant time (O(1)), the time complexity of distinct() can be considered to be O(n). However, if the comparison of elements takes time proportional to the size of the stream (O(n)), the time complexity of distinct() can be considered to be O(n^2).

The actual implementation of distinct() may use various data structures and algorithms to optimize the removal of duplicates. For example, it may use a HashSet or a TreeSet to store the encountered elements and perform efficient uniqueness checks. These data structures have their own time complexities for insertion and lookup operations, which can influence the overall time complexity of distinct().

### 4. **max()**
The max() method is used to find the maximum element in a stream based on a given comparator. It returns an Optional<T> object that represents the maximum element, or an empty Optional if the stream is empty.

The time complexity of the `max()` operation in the Stream API depends on the characteristics of the underlying stream source and the provided comparator (if any).

In summary, the time complexity of the `max()` operation in the Stream API is typically O(n) for sequential streams and O(n / p) for parallel streams, where n is the number of elements and p is the level of parallelism.

### 5. minBy(): 
In Java 8, the minBy collector is used to find the minimum element in a stream based on a specified comparator. It returns an Optional containing the minimum element, or an empty Optional if the stream is empty.
```
 public static <T> Collector<T, ?, Optional<T>> minBy(Comparator<? super T> comparator)
```
### 6. .entrySet()
.entrySet() method of the Map interface to obtain a Set of key-value pairs, and then use the Stream API to perform various operations on those entries.

### 7. Collectors.toMap
In Java, the Collectors.toMap() method is a convenient way to collect elements from a stream into a Map based on specified keys and values.

The toMap() method has multiple overloaded versions, but the most commonly used version takes two lambda expressions: one to extract the key from each element and another to extract the value from each element.


### Question Based on Stream API
1. Get the list of dublicate character from a string ? 
    - DublicateChar
2. Get the employee list with their date of joining ? 
   - employee class attribute: id, name, age, gender, department, yearOfJoining, salary
   - CollectorSample.java
3. Get the employee name list with their year of joining. [solution](https://github.com/keshav-repo/core-java/blob/master/src/main/java/org/learning/strm/CollectorSample.java)
4. Seperate even and odd number in a number list. [solution](https://github.com/keshav-repo/core-java/blob/master/src/main/java/org/learning/strm/CollectorSample.java)
```
input={1, 2, 3, 4, 5, 6}
output: {EVEN=[2, 4, 6], ODD=[1, 3, 5]}
```
5. Get number of employee joining per years. [solution](https://github.com/keshav-repo/core-java/blob/master/src/main/java/org/learning/strm/CollectorSample.java)
6. get Average salary for each department. [solution](https://github.com/keshav-repo/core-java/blob/master/src/main/java/org/learning/strm/CollectorSample.java)
7.  Get the salary sum given per department [solution](https://github.com/keshav-repo/core-java/blob/master/src/main/java/org/learning/strm/CollectorSample.java)
8. Return the list having the length of each word [solution](https://github.com/keshav-repo/core-java/blob/master/src/main/java/org/learning/strm/CollectorSample.java)
```
input: {"John", "Alice", "Bob", "Emma", "Mike", "Sarah"}
output: [4, 5, 3, 4, 4, 5]
```
9. How many male and female employees are there in the organization ?
10. What is the average age of male and female employees?
11. Get the details of highest paid employee in the organization?
12.  Get the names of all employees who have joined after 2015?
13. Count the number of employees in each department?
14. Get the details of youngest male employee in the each department ?
15. Who has the most working experience in the organization
16. How many male and female employees are there in the sales and marketing team ?
17. List down the names of all employees in each department? 
18. What is the average salary and total salary of the whole organization?
19. Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
20. Who is the oldest employee in the organization? What is his age and which department he belongs to?

### Paralle Computing 
1. Get sum of square of number between 1 to 1000000 using parallel computing. 
- solution: ParallelComputingExample.java, SquareOfRange.java
2. Get sum of values from array. 
3. 

