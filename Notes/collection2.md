1. How to Create a Thread-Safe ConcurrentHashSet in Java?
- ConcurrentHashSet can be created by using ConcurrentHashMap as it allows us to use keySet(default value) and newKeySet() methods to return the Set, which happens to be a proper Set.
```
    ConcurrentHashMap<String, Boolean> map = new ConcurrentHashMap<>();
    Set<String> concurrentMap = map.newKeySet();
    concurrentMap.add("456");
    concurrentMap.add("789");
    concurrentMap.add("101112");
```
2.   Differences of using Collections.synchronizedList vs concurrent collection ?
   -  **Synchronization**: Collections.synchronizedList uses a global lock to synchronize access to the list. This means that only one thread can access the list at a time, which can have a performance impact. Concurrent collections, on the other hand, use fine-grained locking, which allows multiple threads to access different parts of the collection at the same time. This can improve performance, especially for collections that are heavily used by multiple threads.
   -  **Scalability**: Collections.synchronizedList is not very scalable for collections that are heavily used by multiple threads. This is because the global lock can cause contention, which can lead to performance bottlenecks. Concurrent collections, on the other hand, are more scalable, because they use fine-grained locking. This allows multiple threads to access different parts of the collection at the same time, which can improve scalability.
   -  **Performance**: Collections.synchronizedList can have a performance impact, because the global lock is acquired on every method call, even if the method is just reading the collection. Concurrent collections, on the other hand, do not acquire a lock on every method call. This can improve performance, especially for collections that are used for reading more than writing.
3. Some of important Collections method. 
- sort: Merge sort is implemented. 
  - Avg Time Compl: O(nlog(n))
  - Worst Time Compl: O(nlon(n))
- binary search 
- copy 
- fill: fill a default value in the collection
- frequency: Get frequency of a element 
```
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class CollectionsMethodDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(9);
        list.add(54);
        list.add(66);
        list.add(76);
        list.add(12);
        list.add(34);

        Collections.sort(list);
        System.out.println(list);

        int idx = Collections.binarySearch(list, 34);
        System.out.println(idx);

        List<Integer> list2 = new ArrayList<>();
        list2.add(90);
        list2.add(12);
        list2.add(98);
        list2.add(43);

        Collections.copy(list, list2);
        System.out.println(list);

        Collections.fill(list2, 0);
        System.out.println(list2);

        System.out.println(Collections.min(list));
        System.out.println(Collections.frequency(list, 12));
    }
}
```
4. What is a enum map ? 
 - an enum map in Java is a map that uses enum types as keys. This means that the keys in an enum map must be enum types, and the values can be any type. Enum maps are represented internally as arrays, which makes them very efficient.
 - Advantages: 
   - They are very efficient.
   - They are easy to use.
   - They are thread-safe.
 - Disadvantages:
   - They can only be used with enum types.
   - They are not as flexible as other types of maps.
```
import java.util.EnumMap;
public class EnumMapDemo {
    public static void main(String[] args) {
        EnumMap<Size, Integer> sizes = new EnumMap<>(Size.class);
        sizes.put(Size.SMALL, 1);
        sizes.put(Size.MEDIUM, 2);
        sizes.put(Size.LARGE, 3);

        int size = sizes.get(Size.MEDIUM);
        System.out.println(size); 
    }
    enum Size {
        SMALL, MEDIUM, LARGE
    }
}
```
5. Arrays class and its important method in java ?
- This class contains various methods for manipulating arrays (such as sorting and searching). This class also contains a static factory that allows arrays to be viewed as lists.
- Important method: 
  - sort
  - binarysearch 
  - fill 
  - copyOf
  - copyOfRange
  - Arrays.asList
  - Arrays.stream
```
import java.util.Arrays;
import java.util.List;

public class ArraysDemo {
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, -1};

        int findIdx = Arrays.binarySearch(num, 9);
        System.out.println(findIdx);

        Arrays.sort(num);

        int[] newArr = Arrays.copyOf(num, num.length * 2);
        int[] rangeArr = Arrays.copyOfRange(num, 0, 5);

        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        List<Integer> list = Arrays.asList(numbers);

        int[] arr2 = new int[10];
        Arrays.fill(arr2, -1);
        Arrays.stream(arr2).forEach(e -> System.out.print(e + ","));
    }
}
```
### 6. Iterator interface ? 
   
The `Iterator` interface in Java provides a way to iterate over elements in a collection sequentially. It defines several methods that allow you to access and traverse the elements of a collection one by one.

Here are some key methods defined in the `Iterator` interface:

- `boolean hasNext()`: Returns `true` if there are more elements in the collection, `false` otherwise.
- `E next()`: Returns the next element in the collection and advances the iterator to the next position.
- `void remove()`: Removes the last element returned by the iterator from the collection (optional operation).
- `default void forEachRemaining(Consumer<? super E> action)`: Performs the given action for each remaining element until all elements have been processed or the action throws an exception.

By using the `Iterator` interface, you can iterate over elements in a collection without exposing the underlying structure of the collection. This provides a standardized way to access and manipulate elements in a collection, regardless of the specific implementation.

Here's an example of how you can use an `Iterator` to iterate over elements in a `List`:

```java
List<String> fruits = Arrays.asList("Apple", "Banana", "Orange");

Iterator<String> iterator = fruits.iterator();
while (iterator.hasNext()) {
    String fruit = iterator.next();
    System.out.println(fruit);
}
```

In this example, the `iterator()` method of the `List` returns an instance of `Iterator`, which is then used to iterate over the elements of the list using the `hasNext()` and `next()` methods.

### 7. What are the benefits of java collection ? 

Java collections provide several benefits that make them a fundamental part of Java programming. Some of the key benefits of Java collections include:

1. Data Organization: Java collections allow you to organize and manage data in a structured manner. They provide different data structures such as lists, sets, maps, queues, and more, allowing you to choose the appropriate collection type based on your requirements.

2. **Efficient Data Access and Manipulation**: Java collections offer efficient algorithms and data structures for accessing and manipulating data. They provide methods for **adding, removing, searching, and modifying elements** in a collection, ensuring fast and optimized operations.

3. **Type Safety**: Java collections provide type safety, which means that you can specify the type of elements that can be stored in a collection. This helps in preventing type-related errors and provides compile-time type checking.

4. **Flexibility and Extensibility**: Java collections are highly flexible and extensible. **They provide interfaces and abstract classes that can be implemented and extended to create custom collection classes tailored to specific needs**. This allows developers to create specialized collections or customize existing collection classes.

5. **Iteration and Stream Operations**: Java collections support iteration and provide various methods to iterate over the elements. Additionally, with the introduction of Java 8 and the Stream API, collections can be easily processed using functional programming constructs, enabling powerful data manipulation operations.

6. **Thread Safety**: Java collections provide thread-safe implementations, such as the `ConcurrentHashMap` and `CopyOnWriteArrayList`, which can be used in concurrent and multi-threaded environments to ensure safe access and modification of data.

7. **Standardized API**: Java collections follow a standardized API design, making them easy to use and understand. The consistent and well-documented API helps developers to quickly learn and work with collections, reducing development time and effort.

Overall, Java collections offer a rich set of features, performance optimizations, and a standardized API, making them a powerful tool for managing and manipulating data in Java applications.

### 8. Implement a custom collection 
```java 
package org.learning.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomCollection<E> implements Collection<E> {
    private E[] elements;
    private int size;

    public CustomCollection() {
        elements = (E[])new Object[10];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new CustomIterator();
    }

    @Override
    public Object[] toArray() {
        return elements;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        if (size > elements.length) {
            return false;
        }
        elements[size++] = e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    private class CustomIterator implements Iterator<E> {
        int currIdx = 0;

        @Override
        public boolean hasNext() {
            return currIdx < size;
        }

        @Override
        public E next() {
            if (hasNext()) {
                E element = elements[currIdx];
                currIdx++;
                return element;
            }
            throw new NoSuchElementException();
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }
    }

    public static void main(String[] args) {
        CustomCollection<Integer> integerCustomCollection = new CustomCollection<>();

        integerCustomCollection.add(10);
        integerCustomCollection.add(20);
        integerCustomCollection.add(30);
        integerCustomCollection.add(40);

       Iterator<Integer> integerIterator = integerCustomCollection.iterator();
       while (integerIterator.hasNext()){
           int next = integerIterator.next();
           System.out.println(next);
       }
    }
}
```
### 9. What is the benefit of Generics in Collections Framework?
- Generics allow us to provide the type of Object that a collection can contain, so if you try to add any element of other type it throws compile time error. 
- This avoids ClassCastException at Runtime because you will get the error at compilation. 
- Also Generics make code clean since we don’t need to use casting and instanceof operator.

### 10. What are the basic interfaces of Java Collections Framework?
- List, Set, Map
- Queue, Dequeue, Iterator, SortedSet, SortedMap and ListIterator.

### 11 Difference between hashtable and hashmap ? 
The main differences between `Hashtable` and `HashMap` in Java are as follows:

1. **Synchronization**: `Hashtable` is synchronized, which means it is thread-safe and can be safely used in concurrent environments. `HashMap` is not synchronized by default, but you can use the `Collections.synchronizedMap()` method to make it synchronized if needed.

2. **Null values and keys**: `Hashtable` does not allow null values or keys. If you try to store a null value or key, it will throw a `NullPointerException`. `HashMap` allows null values and a single null key.

3. **Performance**: `HashMap` is generally considered to have better performance than `Hashtable` because it is not synchronized. In single-threaded scenarios, `HashMap` can be more efficient. However, in multi-threaded scenarios, `Hashtable` can provide better thread safety.

4. **Iterators**: The iterators returned by `Hashtable` and `HashMap` are fail-fast. If the underlying collection is modified while iterating, they will throw a `ConcurrentModificationException`.

5. **Inheritance**: `Hashtable` is a legacy class and implements the `Dictionary` interface. `HashMap` is a newer class and implements the `Map` interface, which is a more versatile and commonly used interface for key-value mappings.

In general, if you need thread-safe behavior or if you are working with legacy code that requires `Hashtable`, you can use it. Otherwise, `HashMap` is recommended for most use cases due to its better performance and flexibility.


### 12. What are different Collection views provided by Map interface with example ? 
The `Map` interface in Java provides several collection views that allow you to access different aspects of the map's data. Here are the different collection views provided by the `Map` interface:

1. **Key Set View**: The key set view (`keySet()`) returns a `Set` of all the keys in the map. This allows you to iterate over or perform operations on just the keys of the map.

```java
Map<String, Integer> map = new HashMap<>();
map.put("A", 1);
map.put("B", 2);
map.put("C", 3);

Set<String> keySet = map.keySet();
System.out.println(keySet); // Output: [A, B, C]
```

2. **Value Collection View**: The value collection view (`values()`) returns a `Collection` of all the values in the map. This allows you to iterate over or perform operations on just the values of the map.

```java
Map<String, Integer> map = new HashMap<>();
map.put("A", 1);
map.put("B", 2);
map.put("C", 3);

Collection<Integer> values = map.values();
System.out.println(values); // Output: [1, 2, 3]
```

3. **Entry Set View**: The entry set view (`entrySet()`) returns a `Set` of all the key-value pairs (entries) in the map. Each entry in the set is represented as a `Map.Entry` object, which provides methods to access the key and value of the entry.

```java
Map<String, Integer> map = new HashMap<>();
map.put("A", 1);
map.put("B", 2);
map.put("C", 3);

Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
for (Map.Entry<String, Integer> entry : entrySet) {
    System.out.println(entry.getKey() + " -> " + entry.getValue());
}
// Output:
// A -> 1
// B -> 2
// C -> 3
```

These collection views allow you to work with different aspects of the map's data in a convenient and efficient manner. They provide different ways to access, iterate, and manipulate the keys, values, and entries of the map.

## 13 How to implement custom hashmap 
```java

public class CustomHashMap<K, V> {
    private Entry<K, V>[] table;
    private int capacity;
    public CustomHashMap() {
        this.capacity = 3;
        this.table = new Entry[this.capacity];
    }
    public void put(K key, V data) {
        if (key == null) {
            return;
        }
        int index = hash(key);
        // create new node
        Entry<K, V> entry = new Entry<>(key, data, null);

        if (table[index] == null) {
            table[index] = entry;
        } else {
            // check if already exist
            Entry<K, V> curr = table[index];
            while (curr.next != null) {
                if (curr.key.equals(key)) {
                    curr.value = data;
                    return;
                }
                curr = curr.next;
            }
            curr.next = entry;
        }
    }

    V get(K key) {
        int index = hash(key);
        Entry<K, V> head = table[index];
        while (head != null) {
            if(head.key.equals(key)){
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    int hash(K key) {
        int hashcode = key.hashCode();
        return Math.abs(hashcode % capacity);
    }

    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;
        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public Entry<K, V>[] getTable() {
        return table;
    }

    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();

        map.put("First", 1);
        map.put("Second", 2);
        map.put("Third", 3);
        map.put("Fourth", 4);
        map.put("Fifth", 5);
        map.put("Sixth", 6);
        map.put("Seventh", 7);

        System.out.println(map.get("Second"));
        
    }
}
```






