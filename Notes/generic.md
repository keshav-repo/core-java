## Generics

**Generics** in Java allow you to create classes, interfaces, and methods that can work with different types. They provide type safety and enable code reuse by allowing you to define classes or methods that can be parameterized with different types.

```
class Box<T> {
    private T content;

    public T getContent() {
        return content;
    }
    public void setContent(T content) {
        this.content = content;
    }
}
public class BoxDemo{
    public static void main(String[] args) {
        Box<Integer> intBox = new Box<>();
        intBox.setContent(10);
        int value = intBox.getContent();
        System.out.println(value);

        Box<String> stringBox = new Box<>();
        stringBox.setContent("Hello world");
        System.out.println(stringBox.getContent());
    }
}
```
2. What are the advantages of using Generics ?
- Type safety: Generics help to prevent errors at compile time by ensuring that the correct types are used in your code. This can help to catch errors early on, which can save you time and frustration.
- Reusability: Generics can help you to make your code more reusable by allowing you to create generic classes and methods that can be used with different types of data. This can save you time and effort, because you don't have to write separate code for each type of data.
- Performance: Generics can sometimes improve performance by allowing the compiler to optimize your code. This is because the compiler can know the exact type of data that is being used, which can help it to generate more efficient code.
- Readability: Generics can help to make your code more readable by making it clear what types of data are being used. This can make your code easier to understand and maintain.
3. How Generics works in Java 
- Generics in Java are a way to write code that is more type-safe and reusable. They work by using type parameters, which areplaceholders for the actual types that will be used in the code.
- Internal working
  - When a generic class or method is declared, the type parameters areplaceholders for the actual types that will be used in the code.
  - When the generic class or method is instantiated, the type parameters are replaced with the actual types that will be used.
  - The compiler ensures that the actual types that are used are compatible with the generic class or method.
4. What is type erasure ?
-   Type erasure is a process in Java that removes type information from generic types at compile time. This means that the bytecode that is generated for generic code does not contain any information about the type parameters that were used to declare the generic types.
- Type erasure is necessary because it allows Java to create generic classes and methods that can be used with different types of data. If type erasure was not used, then the bytecode for generic code would be different for each type of data that was used. This would make it difficult to write generic code that could be used with different types of data.
5. What is Bounded and Unbounded wildcards in Generics ?
- Bounded
  - Upper Bounded Wildcards (<? extends T>):
    - An upper bounded wildcard allows you to specify that the type parameter can be of type T or any subtype of T. 
    - It restricts the unknown type to be a specific upper bound.
  - Lower Bounded Wildcards (<? super T>):
    - A lower bounded wildcard allows you to specify that the type parameter can be of type T or a superclass of T.
    - It restricts the unknown type to be a specific lower bound.
- Unbounded wildcards
  - Unbounded wildcards are used to represent any type. For example, the wildcard ? can be used to represent any type.
- Upper Bounded
```
public static double sumOfNumbers(List<? extends Number> numbers) {
    double sum = 0;
    for (Number number : numbers) {
        sum += number.doubleValue();
    }
    return sum;
}

List<Integer> integers = Arrays.asList(1, 2, 3);
double sumOfIntegers = sumOfNumbers(integers);

List<Double> doubles = Arrays.asList(1.5, 2.5, 3.5);
double sumOfDoubles = sumOfNumbers(doubles);
```
- Lower Bounded
```
public static void addNumbers(List<? super Integer> numbers) {
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
}

List<Integer> integers = new ArrayList<>();
addNumbers(integers);

List<Number> numbers = new ArrayList<>();
addNumbers(numbers);
```
- unbounded
```
public void printElements(List<?> elements) {
    for (Object element : elements) {
        System.out.println(element);
    }
}
```
6. How to write a generic method that accepts a generic argument and returns a Generic Type?
```
public static <T> T genericMethod(T argument) {
    return argument;
}
```
7. How to write parametrized class in Java using Generics?
```
public class ParameterizedClass<T> {

    private T t;

    public ParameterizedClass(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
```
8. Write a program to implement LRU cache using Generics?
- In computer science, the least recently used (LRU) cache is a cache in which the least recently used items are the first to be evicted. This means that the items that have been used the most recently are the ones that are most likely to be used again soon.
```
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<T, V> {

    private final int capacity;
    private final Map<T, V> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<T, V>(capacity, 0.75f, true);
    }

    public void put(T key, V value) {
        if (map.size() == capacity) {
            // Remove the least recently used item from the cache
            T leastRecentlyUsedKey = map.keySet().iterator().next();
            map.remove(leastRecentlyUsedKey);
        }

        map.put(key, value);
    }

    public V get(T key) {
        return map.get(key);
    }
}
```
9. Can you pass List<String> to a method which accepts List<Object>
NO 
10. Can we use Generics with Array?
- No, we cannot use generics with arrays in Java. This is because arrays are implicitly typed, meaning that the type of the elements in an array is determined at compile time. Generics, on the other hand, are explicitly typed, meaning that the type of the elements in a generic collection is determined at runtime.
- 
11.ss 











