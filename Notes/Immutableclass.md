## Immutable Class 

In Java, an immutable class is a class whose instances cannot be modified once they are created. Immutable classes are designed to be thread-safe and have several benefits, including simplicity, ease of understanding, and increased reliability. Here's an example of an immutable class in Java:

```java
import java.util.ArrayList;

public final class ImmutablePerson {
    private final String name;
    private final String age;
    private final List<String> hobbies;

    public ImmutablePerson(String name, String age, List<String> hobbies) {
        this.age = age;
        this.name = name;
        this.hobbies = Collections.unmodifiableList(hobbies);
        // Alternatively, in Java 10+, you can use: this.immutableList = List.copyOf(originalList);   
    }
// only getter, no setter
}
```

To create an immutable class in Java, you need to follow these general principles:
1. Declare the class as final so it can’t be extended.
2. Make all of the fields private so that direct access is not allowed.
3. Don’t provide setter methods for variables.
4. Make all mutable fields final so that a field’s value can be assigned only once.
5. Initialize all fields using a constructor method performing deep copy.
6. If we have non primitive data, also make them immutable 
7. 



