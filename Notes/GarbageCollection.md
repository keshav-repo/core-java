## Garbage Collection

#### Daemon thread
In Java, a daemon thread is a type of thread that runs in the background and provides a service or performs a task without blocking the termination of the main application or other non-daemon threads. Unlike regular threads, daemon threads do not prevent the JVM from exiting when all non-daemon threads have completed their execution.

Here are some key characteristics and behaviors of daemon threads:

1. Background Execution: Daemon threads are typically used for tasks that need to run continuously or perform background operations, such as monitoring, logging, or periodic clean-up tasks. They operate silently in the background without interrupting the main flow of the application.

2. Termination Behavior: When all non-daemon threads have finished executing, the JVM will automatically terminate any remaining daemon threads, abruptly stopping their execution. Daemon threads should not rely on performing critical or essential operations that need to complete gracefully.

3. SetDaemon Method: The `setDaemon(boolean)` method is used to set a thread as a daemon thread. It must be invoked before starting the thread. By default, threads are non-daemon, and the JVM will wait for all non-daemon threads to complete before exiting.

4. Inherited Daemon Status: Threads created by a daemon thread are also daemon threads by default. This means that if a thread is set as a daemon thread, any threads spawned by it will automatically inherit the daemon status.

It's important to note that daemon threads should be used carefully, as they do not provide the same guarantees for completing their tasks as regular threads. Daemon threads are suitable for background tasks that are not critical to the application's main functionality and can be safely abandoned if the JVM terminates.

Here's an example of creating a daemon thread in Java:

```
Thread daemonThread = new Thread(() -> {
    // Background task logic goes here
});
daemonThread.setDaemon(true); // Set the thread as a daemon
daemonThread.start(); // Start the daemon thread
```

In the above example, the `daemonThread` is created as a daemon thread using the `setDaemon(true)` method before starting it with `start()`. The thread will continue running in the background until the JVM terminates or until explicitly stopped or interrupted.

It's important to handle any necessary synchronization or coordination mechanisms within the daemon thread to ensure proper execution and avoid unexpected behavior.

### Islands of Isolation
In Java, the term "Islands of Isolation" refers to a situation where a group of objects becomes unreachable by the rest of the program and therefore eligible for garbage collection, but they still reference each other, preventing their memory from being reclaimed. This creates a memory leak as these objects consume memory unnecessarily.

Here's an example to illustrate the concept of Islands of Isolation:

```
class Island {
    Island otherIsland;

    public void setOtherIsland(Island otherIsland) {
        this.otherIsland = otherIsland;
    }
}

public class IslandsOfIsolationExample {
    public static void main(String[] args) {
        Island island1 = new Island();
        Island island2 = new Island();

        island1.setOtherIsland(island2);
        island2.setOtherIsland(island1);

        // The two Island objects are now referenced by each other
        // but not reachable from the rest of the program

        // At this point, the islands are eligible for garbage collection,
        // but they cannot be reclaimed because they reference each other.

        // The islands create an "Island of Isolation".
    }
}
```

In the above example, two `Island` objects are created (`island1` and `island2`). Each island holds a reference to the other island, creating a circular dependency. Once the `main` method finishes executing, there are no external references to the `Island` objects, making them eligible for garbage collection. However, due to their circular reference, they form an Island of Isolation, preventing them from being garbage collected.

To avoid Islands of Isolation and memory leaks, it's crucial to ensure that objects are properly dereferenced and there are no circular dependencies among objects that can keep them alive unnecessarily. This can be achieved by breaking circular references, making use of weak references, or using appropriate data structures and algorithms to manage object lifecycles effectively.

### Runtime class 
In Java, the `Runtime` class is a class provided by the Java Runtime Environment (JRE) that allows interaction with the underlying operating system environment. It provides methods to execute system commands, manage processes, and access information about the runtime environment.

Here are some important points about the `Runtime` class:

1. Singleton Pattern: The `Runtime` class follows the singleton pattern, meaning that only one instance of the `Runtime` class can exist per Java Virtual Machine (JVM). The singleton instance can be obtained using the static `Runtime.getRuntime()` method.

2. System-Level Operations: The `Runtime` class provides methods to perform system-level operations, such as executing system commands, terminating the JVM, retrieving system properties, and managing environment variables.

3. Process Execution: The `exec(String command)` method of the `Runtime` class allows you to execute system commands from within a Java program. It returns an instance of the `Process` class, which provides methods to control and interact with the spawned process.

4. Resource Limitations: The `Runtime` class provides methods to query and set resource limitations, such as the maximum amount of memory that the JVM can use, the number of processors available, and the maximum file descriptors allowed.

Here's a simple example that demonstrates the usage of the `Runtime` class to execute a system command:

```
public class RuntimeExample {
    public static void main(String[] args) {
        try {
            // Get the singleton instance of Runtime
            Runtime runtime = Runtime.getRuntime();

            // Execute the "ls" command to list files in the current directory
            Process process = runtime.exec("ls");

            // Get the input stream of the process and read the output
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Wait for the process to complete
            int exitCode = process.waitFor();
            System.out.println("Exit Code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```

In the above example, the `Runtime.getRuntime().exec("ls")` method is used to execute the `ls` command to list files in the current directory. The output of the command is read from the process's input stream and printed to the console. The `waitFor()` method is used to wait for the process to complete, and the exit code is obtained.

Please note that the `exec()` method can also take an array of strings to specify command arguments, and it provides various overloaded versions for more advanced process execution scenarios.

Overall, the `Runtime` class provides essential functionality for interacting with the runtime environment and executing system commands from within a Java program.

### References
-https://java-questions.com/garbagecollection-interview-questions.html

