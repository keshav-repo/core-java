### 1. Comparator 
In Java, the Comparator interface is used to define custom comparison logic between objects. It provides methods to compare two objects and determine their order based on specific criteria.
```
interface Comparator<T> {
    int compare(T o1, T o2);
}
```
file ref: EmployeeComparatorBySalary.java
### 2. Comparable 
In Java, the Comparable interface is used to provide a natural ordering for objects of a class. By implementing the Comparable interface, a class defines its own comparison logic, allowing objects of that class to be sorted and compared with each other.

```
interface Comparable<T> {
    int compareTo(T o);
}
```

```
public class Employee implements Comparable<Employee> {
    private String name;
    private int age;

    // Constructor and other methods...

    @Override
    public int compareTo(Employee other) {
        return this.name.compareTo(other.name);
    }
}
```
