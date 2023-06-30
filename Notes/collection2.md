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
6. 


