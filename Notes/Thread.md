## Thread

In Java, a thread is a lightweight unit of execution that represents a single sequential flow of control within a program. It allows multiple tasks to run concurrently within a single program by dividing the program into independent units of execution. Threads enable concurrent and parallel processing, improving performance and responsiveness in applications.

Here are some key points about threads in Java:

1. Multithreading: Java supports multithreading, which means that multiple threads can run concurrently within a single program. Each thread operates independently, executing its own set of instructions.

2. Thread Lifecycle: A thread goes through various states during its lifecycle, including New, Runnable, Running, Blocked, and Terminated. The lifecycle is managed by the JVM and the operating system.

3. Thread Creation: In Java, threads can be created by extending the `Thread` class or implementing the `Runnable` interface. The `Thread` class provides built-in support for thread-related operations and methods.

4. Thread Synchronization: When multiple threads access shared resources or variables, thread synchronization is necessary to ensure data consistency and prevent race conditions. This can be achieved using techniques like synchronized blocks, locks, or higher-level concurrency utilities provided by the Java API.

5. Concurrency Issues: Multithreading introduces concurrency issues such as thread interference, deadlock, and starvation. These issues must be carefully handled to ensure correct and efficient execution of multithreaded applications.

6. Thread Priorities: Threads can be assigned priorities ranging from 1 to 10, with 1 being the lowest priority and 10 being the highest. Thread priorities can influence the scheduling behavior of the underlying operating system.

7. Thread Pooling: To manage and control the number of threads in an application, thread pooling is often used. Thread pools provide a pool of reusable threads that can be assigned tasks, reducing the overhead of creating and destroying threads.

8. Thread Safety: Thread safety is an important concept in multithreaded programming. It refers to the property of a code segment or data structure that can be safely accessed and manipulated by multiple threads concurrently without causing any data inconsistency or unexpected behavior.

By effectively utilizing threads, developers can achieve parallelism, concurrency, and responsiveness in their Java applications. However, it's important to handle synchronization, resource sharing, and other concurrency-related challenges properly to avoid issues such as race conditions or deadlock.

#### 1. Callable interface 
The `Callable` interface is a part of the `java.util.concurrent` package in Java. It represents a task that can be executed asynchronously and returns a result. It is similar to the `Runnable` interface, but with the ability to return a result and potentially throw an exception.

Here are some key points about the `Callable` interface:

1. Functional Interface: The `Callable` interface is a functional interface introduced in Java 5. It is a parameterized interface with a single method `call()`.

2. Return Type: The `call()` method of the `Callable` interface returns a result of a specified type. The result can be obtained by invoking the `get()` method of the `Future` object returned when a `Callable` task is submitted to an executor.

3. Exception Handling: The `call()` method can throw a checked exception. Unlike the `Runnable` interface, which cannot throw checked exceptions directly, the `Callable` interface allows checked exceptions to be thrown by the `call()` method.

4. Asynchronous Execution: The `Callable` interface is often used in conjunction with the `ExecutorService` framework to execute tasks asynchronously. The `ExecutorService` provides methods like `submit()` and `invokeAll()` to execute `Callable` tasks and obtain their results.

5. Use with Executors: The `ExecutorService` framework provides thread pooling and manages the execution of `Callable` tasks. By submitting `Callable` tasks to an executor, the tasks are executed concurrently by multiple threads, and the results can be collected.

6. Future Object: When a `Callable` task is submitted to an executor, it returns a `Future` object. The `Future` object represents the result of the `Callable` task and provides methods to check if the task is completed, retrieve the result, or cancel the task.

Here's a simple example that demonstrates the usage of the `Callable` interface:

```
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> callableTask = () -> {
            Thread.sleep(2000);
            return "Hello, World!";
        };

        Future<String> future = executorService.submit(callableTask);

        try {
            String result = future.get();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}
```

In the above example, a `Callable` task is defined using a lambda expression. It sleeps for 2 seconds and returns the string "Hello, World!". The task is submitted to an `ExecutorService` using the `submit()` method, which returns a `Future` object. The `get()` method is used to retrieve the result of the task.

The `Callable` interface is useful when you need to perform asynchronous computations, obtain results from concurrent tasks, or 
handle exceptions thrown by the tasks. It provides a flexible way to work with concurrent and parallel programming in Java.

#### 2. Executor Service

The `ExecutorService` interface is a part of the `java.util.concurrent` package in Java. It provides a high-level interface for managing and executing tasks asynchronously using a thread pool. It is an extension of the `Executor` interface and provides additional methods for task execution and termination.

Here are some key points about the `ExecutorService` interface:

1. Task Execution: The `ExecutorService` allows you to submit tasks for execution using methods like `submit()`, `execute()`, and `invokeAll()`. Tasks can be submitted as `Runnable` objects or `Callable` objects.

2. Thread Pool Management: The `ExecutorService` manages a pool of worker threads that are used to execute submitted tasks. It handles the creation, reuse, and termination of threads, which helps in efficient thread management and reduces the overhead of thread creation.

3. Asynchronous Execution: Tasks submitted to an `ExecutorService` are executed asynchronously, allowing multiple tasks to be executed concurrently by multiple threads in the thread pool.

4. Task Result Retrieval: The `submit()` method of `ExecutorService` returns a `Future` object that represents the result of a task. The `Future` object can be used to retrieve the result, check if the task is completed, or cancel the task.

5. Task Completion and Shutdown: The `ExecutorService` provides methods like `shutdown()` and `shutdownNow()` to gracefully shut down the executor and terminate the thread pool. The `shutdown()` method allows the executor to finish executing the submitted tasks before shutting down, while `shutdownNow()` attempts to cancel and interrupt the running tasks.

6. Thread Pool Configuration: The `ExecutorService` can be configured with different types of thread pools, such as fixed-size thread pools, cached thread pools, or scheduled thread pools, using utility methods in the `Executors` class.

Here's a simple example that demonstrates the usage of the `ExecutorService` interface:

```
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(() -> {
            System.out.println("Task 1 executed by " + Thread.currentThread().getName());
        });

        executorService.submit(() -> {
            System.out.println("Task 2 executed by " + Thread.currentThread().getName());
        });

        executorService.shutdown();
    }
}
```

In the above example, an `ExecutorService` is created using the `Executors.newFixedThreadPool()` method, which creates a fixed-size thread pool with two worker threads. Two tasks, represented as lambda expressions, are submitted to the executor using the `submit()` method. The tasks are executed concurrently by the worker threads in the thread pool.

The `ExecutorService` interface provides a convenient way to manage and execute tasks asynchronously using thread pools. It helps in simplifying concurrent programming, improving performance, and managing thread resources effectively.

## 3. What is atomic operation? What are atomic classes in Java Concurrency API?
Atomic operations are performed in a single unit of task without interference from other operations. Atomic operations are necessity in multi-threaded environment to avoid data inconsistency.

In Java, the "atomic classes" refer to a group of classes that provide atomic operations on single values without the need for explicit synchronization. These classes are part of the `java.util.concurrent.atomic` package and are primarily used for multi-threaded programming to ensure thread safety and avoid data races. Atomic classes ensure that operations on the underlying value are performed atomically, meaning they are indivisible and thread-safe.

Some of the commonly used atomic classes in Java are:

1. `AtomicInteger`: Provides atomic operations on integers.
2. `AtomicLong`: Provides atomic operations on long integers.
3. `AtomicBoolean`: Provides atomic operations on boolean values.
4. `AtomicReference`: Provides atomic operations on a single reference object.
5. `AtomicIntegerArray`: Provides atomic operations on arrays of integers.
6. `AtomicLongArray`: Provides atomic operations on arrays of long integers.
7. `AtomicReferenceArray`: Provides atomic operations on arrays of reference objects.

The atomic classes use special low-level hardware instructions or software techniques to ensure that the operations on the underlying values are performed atomically and are thus safe to use in multi-threaded environments without the need for explicit synchronization.

For example, consider the `AtomicInteger` class. You can perform atomic operations like `get()`, `set()`, `compareAndSet()`, `incrementAndGet()`, `decrementAndGet()`, etc., on an integer value without worrying about thread interference.

Here's an example of using `AtomicInteger`:

```java
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {
    public static void main(String[] args) {
        AtomicInteger atomicInt = new AtomicInteger(0);
        
        atomicInt.incrementAndGet(); // Increment the value atomically by 1
        atomicInt.addAndGet(5);      // Add 5 to the value atomically
        
        int currentValue = atomicInt.get(); // Get the current value atomically
        System.out.println("Current value: " + currentValue);
    }
}
```

The atomic classes are an essential part of concurrent programming in Java, as they provide a simple and efficient way to work with shared mutable data in multi-threaded scenarios.


# 4. Is there Atomic decimal ?
As of my last update in September 2021, Java does not have a built-in `AtomicDecimal` class in the standard library like `AtomicInteger` or `AtomicLong`. However, you can achieve atomic operations on decimal values using other approaches in Java.

One common approach is to use the `java.util.concurrent.atomic.AtomicReference` class to create an atomic reference to a `BigDecimal` object. Here's an example of how you can use `AtomicReference` with `BigDecimal`:

```java
import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicDecimalExample {
    public static void main(String[] args) {
        AtomicReference<BigDecimal> atomicDecimal = new AtomicReference<>(BigDecimal.ZERO);
        
        atomicDecimal.updateAndGet(currentValue -> currentValue.add(BigDecimal.valueOf(10.5)));
        atomicDecimal.updateAndGet(currentValue -> currentValue.subtract(BigDecimal.valueOf(2.3)));
        
        BigDecimal currentValue = atomicDecimal.get();
        System.out.println("Current value: " + currentValue);
    }
}
```

In this example, we use `AtomicReference` to hold a `BigDecimal` value, and we perform atomic operations on the `BigDecimal` value by using lambda expressions with the `updateAndGet` method.

While Java doesn't have a specific built-in `AtomicDecimal` class, the `AtomicReference` approach allows you to work with `BigDecimal` in a thread-safe manner. Remember that using `AtomicReference` for complex or frequent decimal operations might lead to contention and performance issues due to its locking mechanism. In such cases, consider using other synchronization techniques like `synchronized` blocks or `Lock` interfaces to manage access to shared mutable `BigDecimal` values.

## 5. What is Lock interface in Java Concurrency API
The `Lock` interface in the Java Concurrency API provides a way to control access to shared resources in a multi-threaded environment. It offers more flexibility and control compared to the traditional synchronization achieved through the `synchronized` keyword. The `Lock` interface is part of the `java.util.concurrent` package and provides several methods for acquiring, releasing, and managing locks.

Here are some key methods of the `Lock` interface:

1. `lock()`: Acquires the lock. If the lock is not available, the calling thread will block until it can acquire the lock.

2. `tryLock()`: Attempts to acquire the lock without blocking. If the lock is available, the method returns `true`, and the lock is acquired. If the lock is not available, the method returns `false`, and the thread continues without blocking.

3. `tryLock(long timeout, TimeUnit unit)`: Attempts to acquire the lock, waiting for the specified timeout duration. If the lock is available within the specified time, the method returns `true`, and the lock is acquired. If the lock is not available within the timeout, the method returns `false`, and the thread continues without blocking.

4. `lockInterruptibly()`: Acquires the lock, but if the thread is interrupted while waiting for the lock, it will throw an `InterruptedException`.

5. `unlock()`: Releases the lock, allowing other threads to acquire it.

The most commonly used implementation of the `Lock` interface is `ReentrantLock`, which allows a thread to acquire the same lock multiple times (reentrant locking) without deadlocking itself.

Here's a simple example of using `ReentrantLock`:

```java
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Example {
    private final Lock lock = new ReentrantLock();

    public void performTask() {
        lock.lock(); // Acquire the lock
        try {
            // Critical section: Shared resource access
            // ...
        } finally {
            lock.unlock(); // Release the lock in a finally block to ensure it's always released
        }
    }
}
```

Using `Lock` implementations like `ReentrantLock` allows you to have more control over concurrency, handle lock contention more effectively, and implement more complex synchronization patterns when compared to the traditional `synchronized` blocks.
 
## 6. what is difference between java Lock and Synchronisation ?
The main difference between using a Java `Lock` and synchronization (`synchronized` keyword) lies in the level of control they offer and the flexibility they provide for managing concurrent access to shared resources.

1. Flexibility:
    - `Lock`: Java `Lock` implementations, such as `ReentrantLock`, provide more flexibility in terms of acquiring and releasing locks. They allow for finer-grained control over locking and unlocking, including the **ability to try and acquire a lock without blocking, specifying timeout periods, and supporting different fairness policies.** This added flexibility allows developers to implement more complex synchronization scenarios.
    - Synchronization: The `synchronized` keyword is more straightforward to use and requires less boilerplate code. It automatically acquires and releases locks around synchronized blocks or methods, but it lacks some of the advanced features and fine-tuned control that `Lock` implementations offer.

2. Reentrancy:
    - `Lock`: Most `Lock` implementations, such as `ReentrantLock`, support reentrant locking, which means that a thread can acquire the same lock multiple times without deadlocking itself. This is useful when a method that holds a lock needs to call another method that also requires the same lock, avoiding potential deadlocks.
    - Synchronization: The `synchronized` keyword is reentrant by nature. If a thread already owns the lock acquired through `synchronized`, it can enter any other `synchronized` block or method that requires the same lock without blocking itself.

3. Unblocking and Timeout:
    - `Lock`: Some `Lock` implementations support tryLock(), which allows a thread to attempt to acquire the lock without blocking. Additionally, tryLock() can specify a timeout duration, which means if the lock is not available, the thread will wait for the specified period and then give up the attempt if unsuccessful.
    - Synchronization: The `synchronized` keyword always blocks the thread until the lock is acquired, which means there is no direct support for non-blocking attempts or timeout-based lock acquisition.

4. Condition Variables:
    - `Lock`: `Lock` implementations often come with associated Condition objects, which allow threads to wait and signal based on specific conditions, enabling more complex synchronization patterns.
    - Synchronization: While `synchronized` blocks can use `wait()`, `notify()`, and `notifyAll()` methods to implement similar functionalities, the use of condition variables in `Lock` implementations is generally considered more convenient and explicit.

In summary, `Lock` implementations provide more advanced features, reentrancy support, and fine-grained control over locking and unlocking, making them a powerful choice for managing concurrency in Java. However, they also require more careful management compared to the simpler and more automatic nature of `synchronized` blocks. The choice between `Lock` and `synchronized` depends on the specific requirements and complexity of the concurrency scenario you are dealing with.

## 7. What is ReentrantLock with example in java ?
`ReentrantLock` is a class in Java that provides an alternative to the `synchronized` keyword for managing mutual exclusion and synchronization in multithreaded environments. It allows a lock to be acquired multiple times by the same thread without causing a deadlock, hence the name "Reentrant" lock.

Here's an example of how to use `ReentrantLock` in Java:

```java
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    private final ReentrantLock lock = new ReentrantLock();

    public void performTask() {
        lock.lock();
        try {
            // Critical section - the code that requires exclusive access
            System.out.println("Thread " + Thread.currentThread().getId() + " is performing the task.");
            // Simulate some work being done
            Thread.sleep(1000);
            System.out.println("Thread " + Thread.currentThread().getId() + " completed the task.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockExample example = new ReentrantLockExample();

        // Create multiple threads to simulate concurrent access
        Thread thread1 = new Thread(example::performTask);
        Thread thread2 = new Thread(example::performTask);

        // Start the threads
        thread1.start();
        thread2.start();

        // Wait for both threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```

In this example, we have a `ReentrantLock` instance named `lock`, and the `performTask` method represents the critical section of code that requires exclusive access. The `lock.lock()` method is called to acquire the lock before entering the critical section, and `lock.unlock()` is called after leaving the critical section to release the lock.

Note that the same thread can call `lock.lock()` multiple times without blocking itself. This reentrant behavior is useful when a method needs to call another method that also requires the same lock, preventing potential deadlocks.

`ReentrantLock` provides additional features, such as fairness, which allows the lock to be handed off to the longest waiting thread when the lock becomes available. It also supports condition variables for more advanced synchronization scenarios.

`ReentrantLock` is a flexible and powerful tool for managing concurrency in Java, especially when you need more control over lock acquisition and release than what `synchronized` provides. However, it also requires careful use to avoid potential issues like deadlocks and performance bottlenecks.

## 8. Condition objects in java ?
In Java, the `Condition` interface is part of the `java.util.concurrent.locks` package and is used in conjunction with a `Lock` to implement more advanced forms of thread synchronization and communication. A `Condition` object provides a way for threads to wait for a certain condition to become true before proceeding, similar to the functionality of the `wait()` and `notify()` methods used with traditional object monitors (synchronized blocks).

The main methods provided by the `Condition` interface are:

1. `await()`: Causes the current thread to wait until the condition is signaled. The thread releases the associated lock and waits until another thread calls the `signal()` or `signalAll()` method on the same `Condition` object.

2. `awaitUninterruptibly()`: Similar to `await()`, but the waiting thread will not respond to interruption and will continue to wait even if interrupted.

3. `await(long time, TimeUnit unit)`: Causes the current thread to wait for a specified amount of time until the condition is signaled or until the specified time elapses.

4. `signal()`: Wakes up one waiting thread associated with this `Condition`. If multiple threads are waiting, the specific thread to be awakened is not specified and is implementation-dependent.

5. `signalAll()`: Wakes up all waiting threads associated with this `Condition`. All threads will then compete to re-acquire the associated lock.

Here's an example of using a `Condition` with a `ReentrantLock`:

```java
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Example {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private boolean conditionMet = false;

    public void waitForCondition() {
        lock.lock();
        try {
            while (!conditionMet) {
                condition.await(); // Wait until the condition is signaled
            }
            // Perform action after the condition is met
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signalCondition() {
        lock.lock();
        try {
            conditionMet = true;
            condition.signal(); // Signal that the condition is now true
        } finally {
            lock.unlock();
        }
    }
}
```

In this example, the `waitForCondition()` method waits until the `conditionMet` flag is set to true. The `signalCondition()` method sets the flag to true and then signals the waiting thread using the `signal()` method, allowing it to proceed.

Using `Condition` objects provides a more fine-grained and powerful mechanism for thread coordination and synchronization, allowing you to implement more complex communication patterns between threads.

## 9. My laptop processor is i5-11300H of 11th Generation. Base speed is 3.10 GHz. Ram is 15.8 usable. I am running a java program where I am using ExecutorService. So what is the maximum size of thread pool that i can create.

The maximum size of the thread pool you can create for your Java program using `ExecutorService` depends on several factors, including the number of available CPU cores, the nature of your tasks, and the memory requirements of each task.

As a general rule of thumb, it's not recommended to create a thread pool with a size larger than the number of available CPU cores on your system. This is because creating more threads than there are CPU cores can lead to excessive context switching and reduced performance due to the overhead of managing too many threads.

In your case, your laptop processor, the Intel Core i5-11300H, has 4 cores and 8 threads (due to Hyper-Threading). Therefore, it's generally a good idea to limit the thread pool size to the number of CPU cores or slightly lower to allow for other background processes and system tasks to run efficiently.

You can calculate an appropriate thread pool size by considering the number of available CPU cores, the nature of your tasks (CPU-bound or I/O-bound), and any other concurrent processes running on your system.

For example, to set the thread pool size to the number of CPU cores, you can use the following code:

```java
int availableProcessors = Runtime.getRuntime().availableProcessors();
ExecutorService executorService = Executors.newFixedThreadPool(availableProcessors);
```

This will create a thread pool with a size equal to the number of available CPU cores on your system, which is usually a good starting point.

Keep in mind that if your tasks are heavily I/O-bound (e.g., waiting for external resources, such as reading/writing to files or making network requests), you might be able to use a larger thread pool without significantly affecting performance.

Remember to always monitor the performance of your application and adjust the thread pool size accordingly to find the optimal configuration for your specific use case.

## 10. Blocking Queue 
java.util.concurrent.BlockingQueue is a Queue that supports operations that wait for the queue to become non-empty when retrieving and removing an element, and wait for space to become available in the queue when adding an element.

- BlockingQueue doesn’t accept null values and throw NullPointerException if you try to store null value in the queue. 
- BlockingQueue implementations are thread-safe. All queuing methods are atomic in nature and use internal locks or other forms of concurrency control. 
- BlockingQueue interface is part of the Java collections framework and it’s primarily used for implementing the producer-consumer problem. 
- Java provides several BlockingQueue implementations such as LinkedBlockingQueue, ArrayBlockingQueue, PriorityBlockingQueue
```java
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;

public class BlockingQueueExample {

    public static void main(String[] args) {
        // Create a blocking queue with a capacity of 5
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(5);

        // Create a producer thread to add elements to the queue
        Thread producerThread = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    System.out.println("Producing: " + i);
                    blockingQueue.put(i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Create a consumer thread to remove elements from the queue
        Thread consumerThread = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    int value = blockingQueue.take();
                    System.out.println("Consuming: " + value);
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Start both producer and consumer threads
        producerThread.start();
        consumerThread.start();

        // Wait for both threads to finish
        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```
## 11. what is Future object ? 
In Java, a `Future` object represents the result of an asynchronous computation or task that is being executed in a separate thread. It is a part of the `java.util.concurrent` package and is typically used with `ExecutorService` to submit tasks for asynchronous execution.

When you submit a task to an `ExecutorService`, it returns a `Future` object immediately, which can be **used to retrieve the result of the computation once it is completed**. The `Future` interface provides methods to **check if the computation is done, retrieve the result, or cancel the task if needed.**

Here are some of the important methods provided by the `Future` interface:

1. `boolean isDone()`: Checks if the computation is complete, i.e., if the task has finished execution.

2. `boolean cancel(boolean mayInterruptIfRunning)`: Attempts to cancel the execution of the task. The `mayInterruptIfRunning` parameter determines whether the thread executing the task should be interrupted to cancel the task.

3. `boolean isCancelled()`: Checks if the task has been canceled.

4. `V get() throws InterruptedException, ExecutionException`: Waits for the computation to complete and returns the result. If the computation is not done yet, this method blocks until the result is available. If the computation is canceled or encounters an exception, this method throws `ExecutionException`.

5. `V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException`: Similar to the `get()` method, but with an additional timeout parameter. It waits for the computation to complete within the specified time, and if the result is not available within the timeout, it throws a `TimeoutException`.

Using `Future` objects, you can submit multiple tasks for asynchronous execution, and then later retrieve the results of these tasks as they complete. This allows you to perform concurrent and parallel processing, making better use of available resources and improving the overall performance of your application.

## 12. can we add callback using Future object ? 
No, the standard `Future` object in Java does not directly support adding callbacks. The `Future` interface provides a way to retrieve the result of a computation that may not have completed yet, but it doesn't offer a built-in mechanism for attaching callbacks or handling completion events.

To add a callback for a `Future` object, you typically need to use an additional mechanism, such as `CompletableFuture`, which is a more advanced and flexible implementation of the `Future` interface introduced in Java 8. `CompletableFuture` provides various methods to handle completion events and attach callbacks directly to the future.

Here's an example of how to use `CompletableFuture` to add a callback for a future:

```java
import java.util.concurrent.*;

public class CallbackWithCompletableFuture {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Callable<Integer> task = () -> {
            // Simulate some computation
            Thread.sleep(2000);
            return 42;
        };

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(task, executorService);

        // Attach a callback to the CompletableFuture
        future.thenAccept(result -> System.out.println("Callback Result: " + result));

        executorService.shutdown();
    }
}
```

In this example, we use `CompletableFuture.supplyAsync()` to submit a task asynchronously, and then we chain a callback using the `thenAccept()` method. The `thenAccept()` method takes a `Consumer` that processes the result of the computation when it completes. In this case, the callback simply prints the result.

By using `CompletableFuture`, you can easily handle the completion of the future and define actions to be taken when the computation is finished, making it a powerful tool for working with asynchronous tasks and adding callbacks in Java.

## 13. Future Task ? 
The `FutureTask` class in Java is a useful utility class that implements both the `Runnable` and `Future` interfaces. It represents a computation that may be running asynchronously and produces a result that can be retrieved later. It is typically used in combination with the `Executor` framework to execute tasks in a multi-threaded environment.

`FutureTask` allows you to wrap a computation or a task that returns a result into a `Runnable` object that can be submitted to an `ExecutorService`. It acts as a placeholder for the result of the computation and provides methods to check if the computation is complete, retrieve the result (if available), or block and wait for the result if it's not ready yet.

The main benefit of using `FutureTask` is that it provides a way to offload a potentially time-consuming task to a separate thread and then continue with other operations. The main thread can check the status of the task and retrieve the result later when needed, without being blocked.

Here's a simple example of how to use `FutureTask`:

```java
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Create a FutureTask with a Callable
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                // Simulate some computation
                Thread.sleep(2000);
                return 42;
            }
        });

        // Create a Thread to run the FutureTask
        Thread thread = new Thread(futureTask);
        thread.start();

        // Do other tasks here while the computation is running...

        // Wait for the result of the computation and retrieve it
        int result = futureTask.get();

        System.out.println("Computation Result: " + result);
    }
}
```

In this example, we create a `FutureTask` with a `Callable<Integer>` that represents a computation that returns an integer result. We then create a separate thread to execute the `FutureTask`, which starts the computation asynchronously. The main thread can continue with other tasks while the computation is running. Finally, we use the `get()` method of `FutureTask` to block and wait for the result of the computation.

`FutureTask` provides a convenient way to manage asynchronous tasks and retrieve their results when needed. It's often used in combination with the `Executor` framework for better control over the execution of tasks in a multi-threaded environment.

## 14. Concurrent class 
- ConcurrentHashMap, CopyOnWriteArrayList and CopyOnWriteArraySet
- Concurrent Collection classes support full concurrency of retrievals and adjustable expected concurrency for updates.

## 15 






References
- https://www.digitalocean.com/community/tutorials/java-multithreading-concurrency-interview-questions-answers
- 

