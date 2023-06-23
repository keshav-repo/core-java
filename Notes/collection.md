### What is a collection ?
The root interface in the collection hierarchy. A collection represents a group of objects, known as its elements.

- The default method implementations (inherited or otherwise) do not apply any synchronization protocol. If a Collection implementation has a specific synchronization protocol, then it must override default implementations to apply that protocol.
- Certain methods are specified to be optional. If a collection implementation doesn't implement a particular operation, it should define the corresponding method to throw UnsupportedOperationException. Such methods are marked "optional operation" in method specifications of the collections interfaces.
- Some collection implementations have restrictions on the elements that they may contain. For example, some implementations prohibit null elements, and some have restrictions on the types of their elements. Attempting to add an ineligible element throws an unchecked exception, typically NullPointerException or ClassCastException
```
public interface Collection<E> extends Iterable<E> 

    int size();
    boolean isEmpty();  
    boolean contains(Object o);
    Iterator<E> iterator();
    Object[] toArray();
    <T> T[] toArray(T[] a);
    
    boolean add(E e);
    boolean remove(Object o);
    boolean containsAll(Collection<?> c);
    boolean addAll(Collection<? extends E> c);
    boolean removeAll(Collection<?> c);
    default boolean removeIf(Predicate<? super E> filter) { }
    boolean retainAll(Collection<?> c);
    void clear();
    
    boolean equals(Object o);
    int hashCode();
    
    @Override
    default Spliterator<E> spliterator() {}
    default Stream<E> stream() {}
    default Stream<E> parallelStream() {}
```
**contains**: Returns true if this collection contains the specified element. More formally, returns true if and only if this collection contains at least one element such that Objects.equals(o, e). It can throw exception of below type
- ClassCastException
- NullPointerException
### Collection Hirerachy 
The Collection interface has four direct subclasses: List, Set, Queue, and Deque
```
Collection
    |
    List
        |
        ArrayList
        LinkedList
        Vector
    |
    Set
        |
         HashSet
         LinkedHashSet
         TreeSet
    |
    Queue
        |
        PriorityQueue
    |
    Deque
        |
        ArrayDeque
        LinkedList
```
**The Map** interface is a part of the Java Collections Framework. It represents a mapping between a key and a value. Maps are not a subclass of the Collection interface, but they can be viewed as a collection of key-value pairs.

### List Interface
An ordered collection. 

Here are some important points about the List interface in Java:

1. **Ordered Collection**: The List interface represents an ordered collection of elements, where each element has an index associated with it. It maintains the insertion order of elements and allows duplicates.

2. **Positional Access**: Lists provide positional access to elements, meaning you can retrieve, modify, or remove elements based on their index. The index starts from 0 for the first element and goes up to (size - 1) for the last element.

3. **Dynamic Size**: Lists can dynamically grow and shrink in size as elements are added or removed. They do not have a fixed length, unlike arrays.

4. **Allows Duplicates**: Unlike sets, lists allow duplicate elements. You can add multiple occurrences of the same element at different positions in the list.

5. **Implementations**: Java provides several implementations of the List interface, including ArrayList, LinkedList, and Vector. Each implementation has its own characteristics in terms of performance, memory usage, and thread-safety.

6. **Random Access**: Lists support efficient random access to elements by index. ArrayList, for example, provides constant-time (O(1)) access to elements, allowing you to directly retrieve or modify elements at any given index.

7. **Iterating over Elements**: You can iterate over the elements of a List using a for loop, enhanced for loop, or Iterator. The List interface extends the Iterable interface, allowing you to use the enhanced for loop directly.

8. **Modifying Operations**: Lists provide methods to add, remove, and modify elements. Some commonly used methods include `add`, `remove`, `get`, `set`, `indexOf`, `lastIndexOf`, `subList`, and `addAll`.

9. **Sorting and Searching**: Lists offer methods to sort their elements using the `Collections.sort` method or the `sort` method of specific list implementations. They also provide methods to search for elements, such as `contains`, `indexOf`, and `lastIndexOf`.

10. **Concurrency**: Most List implementations are not thread-safe by default. However, you can use synchronization mechanisms or utilize thread-safe implementations like Vector or synchronized wrappers provided by the `Collections` class to make them thread-safe.

The `List` interface in Java extends the `Collection` interface and adds several additional methods that are specific to lists. These methods provide additional functionality for accessing and manipulating elements in a list.

Here are some methods that are present in the `List` interface but not in the `Collection` interface:

1. `void add(int index, E element)`: Inserts the specified element at the specified position in the list.
2. `boolean remove(Object o)`: Removes the first occurrence of the specified element from the list, if it is present.
3. `E remove(int index)`: Removes the element at the specified position in the list and returns it.
4. `E get(int index)`: Returns the element at the specified position in the list.
5. `E set(int index, E element)`: Replaces the element at the specified position in the list with the specified element and returns the original element.
6. `int indexOf(Object o)`: Returns the index of the first occurrence of the specified element in the list, or -1 if the element is not found.
7. `int lastIndexOf(Object o)`: Returns the index of the last occurrence of the specified element in the list, or -1 if the element is not found.
8. `List<E> subList(int fromIndex, int toIndex)`: Returns a view of the portion of the list between the specified `fromIndex` (inclusive) and `toIndex` (exclusive).
9. `void sort(Comparator<? super E> c)`: Sorts the elements of the list according to the specified comparator.

#### List interface implementation: 
- ArrayList
  - Array
  - Fast for random access
  - Not thread-safe
- LinkedList
  - Linked List
  - Fast for adding and removing elements
  - Not thread-safe
- Vector
  - Array
  - Slow for random access
  - Thread-safe
- CopyOnWriteArrayList
  - Array
  - Fast for random access
  - Thread-safe

#### Difference between array list and linked list 

|  Feature   | ArrayList    |  LinkedList   |
|-----|-----|-----|
|Efficiency|"Fast for random access slow for adding/removing elements"|"Slow for random access| fast for adding/removing elements"|
|Thread-safety|Not thread-safe|Not thread-safe|
|Implementation|java.util.ArrayList|java.util.LinkedList|
| Storage | Array | Linked list |

#### Difference between array list and vector 
|  Feature   | ArrayList                                                | LinkedList                                                 |
|-----|----------------------------------------------------------|------------------------------------------------------------|
|Efficiency	| Fast for random access, slow for adding/removing elements | 	Slow for random access, slow for adding/removing elements |
| Thread-safety| Not thread-safe| Thread-safe |

#### vector sample code 
```
Vector<String> vector = new Vector<>();

// Adding elements
vector.add("Apple");
vector.add("Banana");
vector.add("Orange");
```

#### CopyOnWriteArrayList 

1. Underlying Array: The `CopyOnWriteArrayList` maintains an underlying array that holds the elements of the list. This array is volatile, meaning that changes to the array are immediately visible to other threads.

2. Copying Mechanism: Whenever a mutative operation (add, remove, etc.) is performed on the list, the `CopyOnWriteArrayList` creates a new copy of the underlying array. The modification is then applied to the new copy, leaving the original array unchanged.

3. Read Operations: Concurrent readers can safely access the list while modifications are being made. The read operations, such as `get()` or `iterator()`, operate on the original array, ensuring that the readers see a consistent snapshot of the list as it was when they started reading.

4. Visibility Guarantees: The `CopyOnWriteArrayList` ensures that modifications made by one thread are visible to subsequent threads. When a thread performs a mutative operation and obtains a new copy of the array, it guarantees that the modifications made by that thread are visible to subsequent read operations performed by other threads.

5. Overhead: The copying mechanism of `CopyOnWriteArrayList` introduces overhead in terms of memory consumption and performance. Each modification creates a new copy of the array, which can be expensive for large lists. However, the benefit is that concurrent reads do not require any locking or synchronization, resulting in efficient read operations.

```
 final transient Object lock = new Object();
 
 private transient volatile Object[] array;
 
 public boolean add(E e) {
    synchronized (lock) {
        Object[] es = getArray();
        int len = es.length;
        es = Arrays.copyOf(es, len + 1);
        es[len] = e;
        setArray(es);
        return true;
    }
}
```
[stackoverflow](https://stackoverflow.com/a/2950898/7502769)

#### transient and volatile Keyword
Using volatile is yet another way (like synchronized, atomic wrapper) of making class thread-safe. Thread-safe means that a method or class instance can be used by multiple threads at the same time without any problem.
The Java volatile keyword guarantees visibility of changes to variables across threads.

- [youtube](https://youtu.be/V2hC-g6FoGc)
- src/main/java/org/learning/collection/VolatileDemo.java

### Queue in Java 
Collection interface is used to hold the elements about to be processed in FIFO(First In First Out) order.

```
public interface Queue<E> extends Collection<E> {
boolean add(E e);
boolean offer(E e);
E remove();
E poll();
E element();
E peek();
```

| Implementation |Storage |	Efficiency|Thread-safety|
|---|---|---|---|
|LinkedList|Linked list|Efficient for both adding and removing elements|Not thread-safe|
|ArrayBlockingQueue|Array|Efficient for adding and removing elements|Thread-safe|
|PriorityQueue|Heap|Efficient for adding and removing elements|Not thread-safe|

#### Priority Queue
1. Binary Heap: The `PriorityQueue` maintains a **binary heap**, which is a **complete binary tree** with a special property. In a binary heap, the parent node always has a higher (or equal) priority than its child nodes.

2. Array-Based Implementation: The binary heap is typically **implemented using an array**. The elements of the `PriorityQueue` are stored in the array in a specific order that satisfies the heap property.

3. Priority Order: The priority of elements in the `PriorityQueue` is determined either by their **natural ordering** (if they implement the `Comparable` interface) or by a custom `Comparator` provided during the `PriorityQueue` creation.

4. Insertion: When an element is inserted into the `PriorityQueue`, it is added at the next available position in the array, maintaining the complete binary tree structure. The element is then "bubbled up" or "swapped up" through the tree until it reaches the correct position based on its priority.

5. Removal: When an element is removed from the `PriorityQueue`, the root element (the element with the highest priority) is taken out from the array. The last element in the array replaces the root element, and then the element is "bubbled down" or "swapped down" through the tree until it reaches the correct position based on its priority.

6. Efficient Operations: The binary heap structure allows efficient insertion and removal operations. **Insertion has a time complexity of O(log n)** since it involves comparing the element with its parent and potentially swapping it multiple times. **Removal of the highest-priority element has a time complexity of O(log n)** as well since it involves replacing the root element and then adjusting the heap.
```
 PriorityQueue<Integer> queue = new PriorityQueue<>();      
queue.add(10);
queue.add(5);
queue.add(15);
```

### ArrayBlockingQueue

The `ArrayBlockingQueue` class in Java is a bounded implementation of the `BlockingQueue` interface. It represents a thread-safe queue where elements are stored in a fixed-size array. The maximum capacity of the `ArrayBlockingQueue` is specified when creating an instance of the class.

```
ArrayBlockingQueue<E> extends AbstractQueue<E> implements BlockingQueue<E>, java.io.Serializable{

public boolean offer(E e) {
    Objects.requireNonNull(e);
    final ReentrantLock lock = this.lock;
    lock.lock();
    try {
        if (count == items.length)
            return false;
        else {
            enqueue(e);
            return true;
        }
    } finally {
        lock.unlock();
    }
}

public E poll() {
    final ReentrantLock lock = this.lock;
    lock.lock();
    try {
        return (count == 0) ? null : dequeue();
    } finally {
        lock.unlock();
    }
}
```

#### Here are some key features and characteristics of `ArrayBlockingQueue`:

1. Bounded Capacity: `ArrayBlockingQueue` has a **fixed capacity**, meaning that it can only hold a certain number of elements at a time. The capacity is specified during the initialization of the queue and cannot be changed afterwards.

2. FIFO Ordering: The elements in the `ArrayBlockingQueue` are ordered based on the FIFO (First-In-First-Out) principle. The first element inserted into the queue will be the first one to be removed.

3. Blocking Operations: `ArrayBlockingQueue` provides blocking operations for adding and removing elements. When the queue is full and an attempt is made to add an element, the operation will block until space becomes available. Similarly, when the queue is empty and an attempt is made to remove an element, the operation will block until an element is available.

4. Thread-Safety: `ArrayBlockingQueue` is designed to be thread-safe, allowing concurrent access from multiple threads without the need for external synchronization. The internal mechanisms of the class ensure proper synchronization to maintain data consistency and prevent race conditions.

5. Array-Based Implementation: The underlying data structure of `ArrayBlockingQueue` is an **array**. The elements are stored in the array in the order of their insertion, and additional elements are added or removed by updating the appropriate indexes.

6. Blocking Methods: `ArrayBlockingQueue` provides various blocking methods, such as `put()` and `take()`, which block the calling thread until the requested operation can be performed. These methods are useful for coordinating producer-consumer scenarios or controlling the flow of data between threads.

The `ArrayBlockingQueue` is commonly used in scenarios where a fixed-size queue is required, and thread-safe operations with blocking behavior are desired. It is especially useful for implementing producer-consumer patterns or scenarios where the flow of data needs to be controlled between threads.

Note that while `ArrayBlockingQueue` provides thread-safe operations, it is still possible to create deadlocks or other synchronization issues if not used properly. Care should be taken to ensure correct usage and proper handling of concurrency-related concerns.

#### **Scenario where ArrayBlockingQueue can be used:** 

1. Producer-Consumer Pattern: `ArrayBlockingQueue` is commonly used in producer-consumer scenarios, where one or more threads produce data and one or more threads consume that data. The queue acts as a buffer between the producers and consumers, allowing them to work at different speeds and decoupling their interactions.

2. Task Scheduling: `ArrayBlockingQueue` can be used in task scheduling scenarios, where tasks or jobs need to be processed by worker threads. The tasks can be added to the queue, and worker threads can take the tasks from the queue and execute them. The blocking behavior of the queue ensures that worker threads wait when the queue is empty and resume processing as new tasks become available.

3. Event Handling: In event-driven systems, events are often produced asynchronously and need to be processed by multiple consumers. `ArrayBlockingQueue` can be used to store the incoming events, allowing multiple consumers to process them concurrently. This ensures thread-safety and orderly handling of events.

4. Resource Pooling: `ArrayBlockingQueue` can be used in scenarios where a pool of resources (such as database connections, threads, or reusable objects) needs to be managed. The resources can be pre-initialized and added to the queue. Worker threads can then request resources from the queue, and once they are done, they can return the resources to the queue for reuse.

5. Message Passing: `ArrayBlockingQueue` can be used for inter-thread or inter-process communication, where messages need to be passed between different components. The queue can be shared between the sending and receiving threads or processes, allowing them to exchange messages safely and efficiently.

In all these scenarios, the bounded nature of `ArrayBlockingQueue` ensures that the queue does not grow indefinitely, preventing resource exhaustion. The thread-safe and blocking behavior of the queue ensures proper synchronization and coordination between the producing and consuming threads or components.

It's important to choose the appropriate queue implementation based on the specific requirements of your application. If dynamic resizing or unbounded capacity is needed, other implementations like `LinkedBlockingQueue` or `ConcurrentLinkedQueue` may be more suitable.

#### Internal working
Internally, `ArrayBlockingQueue` in Java is implemented using an array to store the elements and two pointers, `head` and `tail`, to keep track of the current positions for adding and removing elements.

Here's a brief overview of how `ArrayBlockingQueue` works internally:

1. Array Storage: `ArrayBlockingQueue` maintains a fixed-size array to store the elements. The size of the array is specified during initialization and remains constant throughout the lifetime of the queue.

2. **Head and Tail Pointers**: The queue uses two pointers, `head` and `tail`, to track the current positions for adding and removing elements. The `head` pointer points to the first element of the queue, and the `tail` pointer points to the position where the next element will be added.

3. **Circular Array**: The array used by `ArrayBlockingQueue` is treated as a circular buffer. This means that when the `tail` pointer reaches the end of the array, it wraps around to the beginning. This allows for efficient reuse of the array space without having to shift elements.

4. **Blocking Operations**: When adding an element to a full `ArrayBlockingQueue`, the operation blocks until space becomes available. Similarly, when removing an element from an empty queue, the operation blocks until an element is available. This blocking behavior is achieved using intrinsic locks and condition variables.

5. **Synchronization**: `ArrayBlockingQueue` ensures thread-safety by using intrinsic locks and other synchronization mechanisms. The internal methods for adding and removing elements are synchronized to prevent concurrent access issues.

6. Ordering: `ArrayBlockingQueue` maintains the order of elements based on the FIFO (First-In-First-Out) principle. The first element added to the queue will be the first one to be removed.

7. Atomic Operations: `ArrayBlockingQueue` uses atomic operations to update the `head` and `tail` pointers, ensuring that multiple threads can safely access and modify the queue's internal state without conflicts.

Overall, `ArrayBlockingQueue` provides a bounded, thread-safe, and blocking queue implementation by efficiently managing the array storage and using synchronization mechanisms to handle concurrent access. The circular array structure allows for efficient reuse of the available space, and the blocking operations ensure proper coordination between producers and consumers.

#### Time Complexity
The time complexity of operations in `ArrayBlockingQueue` can be summarized as follows:

1. Add/Insertion (`add`, `offer`, `put`): The time complexity of adding an element to the `ArrayBlockingQueue` depends on whether the queue is full or not. If the queue is not full, the operation is generally O(1) constant time, as it involves inserting the element at the `tail` position and updating the `tail` pointer. However, if the queue is full and the insertion operation needs to wait for space to become available, it can become a blocking operation and the time complexity will depend on external factors.

2. Remove/Deletion (`remove`, `poll`, `take`): The time complexity of removing an element from the `ArrayBlockingQueue` is also generally O(1) constant time. The element at the `head` position is removed, and the `head` pointer is updated to the next position. Similar to the add operation, if the queue is empty and the removal operation needs to wait for an element to become available, it can become a blocking operation with a time complexity that depends on external factors.

3. Get/Retrieval (`peek`, `element`): The time complexity of retrieving an element from the `ArrayBlockingQueue` without removing it is O(1) constant time. The element at the `head` position can be accessed directly.

Example: [ArrayBlockingQueueDemo](https://github.com/keshav-repo/core-java/blob/master/src/main/java/org/learning/collection/ArrayBlockingQueueDemo.java) 

### Linked List Queue:
In Java, a linked list-based implementation of a queue is available through the LinkedList class. The LinkedList class in Java provides the functionality of both a list and a queue, allowing elements to be added and removed from both ends.

**Time complexity of operations**
1. Enqueue/Add Operation: The time complexity of adding an element to the end of the linked list (enqueue operation) is O(1) constant time. Since the linked list keeps a reference to both the head and tail nodes, adding an element at the tail can be done in constant time.
2. Dequeue/Remove Operation: The time complexity of removing an element from the front of the linked list (dequeue operation) is also O(1) constant time. Similar to the enqueue operation, removing the head element can be done in constant time since the linked list keeps a reference to the head node.
3. Peek Operation: The time complexity of peeking at the element at the front of the linked list (peek operation) is O(1) constant time. Accessing the head element directly can be done in constant time.
4. Search Operation: The time complexity of searching for an element in the linked list queue is O(n), where n is the number of elements in the queue. Since the linked list does not provide direct indexing, searching for an element requires traversing the list from the head to the tail.

Example: [ArrayBlockingQueueDemo](https://github.com/keshav-repo/core-java/blob/master/src/main/java/org/learning/collection/LinkedListQueueExample.java)

### Concurrent Collection APi

### Unmodifidable Collection

###  Concurrent collection in java 
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

### 
