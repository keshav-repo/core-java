### 1. What is clonable and serializable interface ? 

The `Cloneable` interface in Java is **a marker interface that indicates that a class can be cloned**, i.e., it can create a copy of itself. It is a part of the Java object cloning mechanism.

The `Cloneable` interface itself does not define any methods. Its purpose is to enable the `clone()` method defined in the `Object` class to create a shallow copy of an object if the class implements `Cloneable`. The `clone()` method is declared as protected in the `Object` class, so in order to use it, you need to override it with the `public` access modifier in your class.

Here's an example of a class implementing the `Cloneable` interface and overriding the `clone()` method:

```java
public class MyClass implements Cloneable {
    private int value;

    public MyClass(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
```
The `Serializable` interface in Java is a marker interface that indicates that a class can be serialized. Serialization is the process of converting an object into a byte stream, which can be stored in a file, sent over a network, or saved in a database. By implementing the `Serializable` interface, a class allows its objects to be converted into a byte stream and vice versa.

The `Serializable` interface itself does not declare any methods. It is used to indicate to the Java runtime that an object of the implementing class can be serialized. When an object is serialized, its state, including the values of its fields, is converted into a sequence of bytes. This allows the object to be stored, transmitted, or reconstructed later.

Here's an example of a class implementing the `Serializable` interface:

```java
import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private int age;

    // constructor, getters, setters, etc.
}
```

In this example, the `Person` class implements the `Serializable` interface, which means objects of this class can be serialized. The actual serialization and deserialization process is typically handled by a serialization framework or by using the Java built-in mechanisms like `ObjectOutputStream` and `ObjectInputStream`.

It's important to note that not all classes can or should be serialized. Some classes, such as those containing sensitive information or those with non-serializable fields, may need to be marked as `transient` or implement custom serialization logic to control the serialization process.

### 2. How to do custom serialisation ? 
When implementing the `Serializable` interface in Java, you need to follow certain guidelines and considerations. Here's an example of a custom implementation of the `Serializable` interface:

```java
import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 123456789L;

    private String name;
    private int age;

    // constructor, getters, setters, etc.

    private void writeObject(java.io.ObjectOutputStream out) throws IOException {
        // Custom serialization logic
        out.writeObject(name);
        out.writeInt(age);
    }

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        // Custom deserialization logic
        name = (String) in.readObject();
        age = in.readInt();
    }
}
```

In this example, the `Person` class implements the `Serializable` interface and provides custom serialization and deserialization methods: `writeObject()` and `readObject()`. By implementing these methods, you can have fine-grained control over the serialization process.

The `writeObject()` method is responsible for writing the object's state to the output stream, and the `readObject()` method is responsible for reading the object's state from the input stream. You can write and read each field individually or perform additional custom logic as needed.

It's important to note that when providing custom serialization and deserialization methods, you need to handle any exceptions that may occur, such as `IOException` and `ClassNotFoundException`. Additionally, you should define a `serialVersionUID` field, as shown in the example, to ensure version compatibility when serializing and deserializing objects.

### 3. what is enumerator ?
An enumerator, also known as an enumeration or an enum, **is a data type in programming that represents a set of predefined named values**. It is used to define a fixed set of constants that can be assigned to variables or used in control flow statements.

In Java, an enumerator is defined using the `enum` keyword. It allows you to define a list of named constants, each represented by an instance of the enum type. Enums can have methods, constructors, and other fields like any other Java class.

Here's an example of defining an enumerator in Java:

```java
public enum DayOfWeek {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}
```

In this example, the `DayOfWeek` enum represents the days of the week as named constants. Each constant (e.g., `MONDAY`, `TUESDAY`, etc.) represents an instance of the `DayOfWeek` enum.

Enums can be used in switch statements, comparisons, and as the type of variables. They provide a convenient way to define and work with a fixed set of values in a type-safe manner.

### 4. Fail fast in java collection 
**In Java collections, "fail fast" refers to the behavior of throwing a `ConcurrentModificationException` if a collection is structurally modified while it is being iterated over. This is done to detect and prevent concurrent modification, which can lead to inconsistent or unexpected behavior.**

The fail-fast behavior ensures that if a collection is modified during iteration, an exception is immediately thrown, indicating that the collection has been concurrently modified and the current iteration cannot continue. This helps to catch and fix potential bugs or unintended modifications to the collection.

For example, consider the following code:

```java
List<String> names = new ArrayList<>();
names.add("Alice");
names.add("Bob");
names.add("Charlie");

for (String name : names) {
    System.out.println(name);
    names.add("Dave");  // Concurrent modification
}
```

In this code, a new element is added to the `names` list during iteration, which is a concurrent modification. As a result, a `ConcurrentModificationException` will be thrown at runtime, indicating the failure.

Fail-fast behavior helps in identifying and resolving issues related to concurrent modification. It encourages developers to write code that avoids modifying a collection while it is being iterated, or to use appropriate thread-safe alternatives like concurrent collections when concurrent modification is required.

It's important to note that the fail-fast behavior is not guaranteed to occur in all cases, such as when modifications are performed using iterator's own methods like `remove()`. Additionally, fail-fast behavior is specific to certain collections like `ArrayList` and `HashMap`, while some collections like `CopyOnWriteArrayList` and `ConcurrentHashMap` exhibit different concurrency behavior.

### 5. What are the best practices for choosing key for a map ? 
When choosing a key for a map in Java, it's important to consider the following best practices:

1. Uniqueness: The key should be unique within the map. If multiple entries with the same key are added, they will overwrite each other.

2. **Immutability**: Ideally, the key should be immutable. Immutable keys ensure that their hash code and equality remain consistent, preventing unexpected behavior in the map.

3. **Consistent Hashing**: The key's `hashCode()` method should be implemented properly to generate a consistent hash value. The hash code should be calculated based on the key's internal state that is used for equality comparison. It's important to override the `hashCode()` method if you're using custom objects as keys.

4. **Correct Equality**: The key's `equals()` method should be implemented correctly to ensure proper equality comparison. The `equals()` method should be consistent with the `hashCode()` method.

5. Simplicity and Readability: Choose keys that are simple and readable. Keys should provide clear and meaningful identification for the associated values.

6. Performance: Consider the performance implications of key operations, such as hashing and equality comparison. Efficient key design can improve the overall performance of map operations.

7. Type Compatibility: Ensure that the key type is compatible with the map's requirements and operations. For example, if you're using a TreeMap, the key should implement the `Comparable` interface or be provided with a custom `Comparator`.

8. Avoiding Mutable Keys: It's generally recommended to avoid using mutable objects as keys in a map. If a key is mutable, and its internal state is modified after being used as a key, it can lead to unpredictable behavior in the map.

By following these best practices, you can choose appropriate keys for your map that provide efficient and reliable functionality.


### 6. What should be idea of implementing comparable and comparator for a class ? 
The idea behind implementing the `Comparable` and `Comparator` interfaces in Java is to provide a way to define a total ordering or custom sorting logic for objects of a class. 

Implementing the `Comparable` interface allows you to define the natural ordering of objects within the class itself. The `Comparable` interface includes a single method, `compareTo()`, which compares the current object with another object of the same type. By implementing this method, you specify the rules for comparing objects and determining their relative order. The natural ordering is typically based on one or more properties or fields of the class.

On the other hand, implementing the `Comparator` interface allows you to define custom comparison logic for objects of a class without modifying the class itself. The `Comparator` interface also includes a single method, `compare()`, which takes two objects as arguments and returns an integer representing their relative order. By implementing this method, you can define specific comparison rules for sorting objects based on different criteria or properties.

In summary, implementing `Comparable` is useful when you want to define the natural ordering of objects within a class, while implementing `Comparator` is useful when you want to provide custom sorting logic for objects without modifying the class itself. Both interfaces enable you to control how objects of a class are compared and sorted in various scenarios.

### 7. If we are keeping a object as key for TreeMap, why we should implement compactor for the key ? 
When using an object as a key in a `TreeMap`, it is important to implement the `Comparable` interface or provide a custom `Comparator` to establish the ordering of the keys. The reason for this is that `TreeMap` relies on the keys being ordered to maintain its internal data structure.

Here's why implementing `Comparable` or providing a `Comparator` is necessary:

1. **Natural Ordering**: If the object has a natural ordering, meaning it has a clear and consistent way to determine its relative order, you should implement the `Comparable` interface. This allows the `TreeMap` to use the `compareTo()` method to compare keys and maintain the natural ordering automatically.

2. **Custom Ordering**: If the object doesn't have a natural ordering or if you want to define a different ordering than the natural one, you can provide a custom `Comparator`. This allows you to define your own comparison logic in the `compare()` method and use it to order the keys in the `TreeMap`.

By implementing `Comparable` or providing a `Comparator`, you ensure that the keys are properly ordered, allowing `TreeMap` to efficiently perform operations like searching, insertion, and retrieval based on the key's ordering. If the keys are not ordered correctly, the `TreeMap` may not function as expected and may produce incorrect results.

In summary, implementing `Comparable` or providing a `Comparator` for the keys in a `TreeMap` ensures that the keys are properly ordered, enabling the `TreeMap` to function correctly and efficiently.

### 8. Is java pass by value or pass by reference ? 
In Java, when you pass a variable as an argument to a method, the value of the variable is passed to the method. This is known as "pass-by-value." However, it is essential to understand that the term "value" can be misleading in the context of objects.

When you pass a primitive data type (e.g., int, float, boolean) to a method, Java passes a copy of the value of the variable to the method. Any modifications made to the parameter inside the method do not affect the original variable.

Example with primitive data type:

```java
public class PassByValueExample {
    public static void main(String[] args) {
        int number = 10;
        System.out.println("Before calling modifyNumber method: " + number);
        modifyNumber(number);
        System.out.println("After calling modifyNumber method: " + number);
    }

    public static void modifyNumber(int num) {
        num = 20;
    }
}
```

Output:

```
Before calling modifyNumber method: 10
After calling modifyNumber method: 10
```

In the above example, the value of the variable `number` remains unchanged after calling the `modifyNumber` method.

When you pass an object (non-primitive data type) to a method, Java passes a copy of the reference to the object (i.e., the memory address where the object is stored) to the method. While the reference itself is copied, both the original reference and the method parameter point to the same object in memory. As a result, changes made to the object inside the method are reflected in the original object.

Example with objects:

```java
public class PassByValueExample {
    public static void main(String[] args) {
        StringBuilder message = new StringBuilder("Hello");
        System.out.println("Before calling modifyMessage method: " + message);
        modifyMessage(message);
        System.out.println("After calling modifyMessage method: " + message);
    }

    public static void modifyMessage(StringBuilder msg) {
        msg.append(" World!");
    }
}
```

Output:

```
Before calling modifyMessage method: Hello
After calling modifyMessage method: Hello World!
```

In this example, the content of the `StringBuilder` object is modified inside the `modifyMessage` method, and the change is reflected in the original `message` object.

So, in summary, Java is pass-by-value, but when objects are passed, the value that is passed is a copy of the reference to the object, not the object itself.











