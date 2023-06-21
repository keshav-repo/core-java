### 1. Concurrent collection in java 
Concurrent collections in Java are thread-safe versions of the standard collections provided by the Java Collections Framework. They are designed to be used in concurrent multi-threaded environments where multiple threads access and modify collections simultaneously.

The standard collections in Java, such as `ArrayList` and `HashMap`, are not thread-safe by default. When multiple threads try to modify a non-thread-safe collection concurrently, it can lead to data inconsistencies and unexpected behavior.

Concurrent collections provide the following benefits:

1. Thread Safety: Concurrent collections are designed to be thread-safe. They use various synchronization mechanisms to ensure that multiple threads can safely access and modify the collection without causing data corruption or race conditions.

2. Atomic Operations: Concurrent collections provide atomic operations that are thread-safe and can be executed in a single, indivisible step. This means that multiple threads can perform operations on the collection concurrently without interfering with each other.

3. High Performance: Concurrent collections are optimized for concurrent access. They provide efficient and scalable implementations that minimize contention between threads and maximize throughput in multi-threaded scenarios.

Some commonly used concurrent collections in Java are:

1. **ConcurrentHashMap**: A thread-safe implementation of the `Map` interface. It provides high-performance and concurrent access to key-value pairs.

2. **ConcurrentLinkedQueue**: A thread-safe implementation of the `Queue` interface. It allows multiple threads to add, remove, and access elements concurrently in a first-in-first-out (FIFO) manner.

3. **ConcurrentSkipListSet** and **ConcurrentSkipListMap**: Thread-safe implementations of the `SortedSet` and `SortedMap` interfaces, respectively. They provide concurrent access to elements in sorted order.

4. **CopyOnWriteArrayList** and **CopyOnWriteArraySet**: Thread-safe implementations of the `List` and `Set` interfaces, respectively. They provide thread-safe iteration and are optimized for scenarios where the collection is primarily read rather than modified.

When working in multi-threaded environments, it is important to choose the appropriate concurrent collection based on the specific requirements of your application. By using concurrent collections, you can ensure thread safety and avoid data inconsistencies when multiple threads access and modify collections concurrently.

### 2. Collector class main method and its working ? 
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

### 3. 

