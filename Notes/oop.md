[Object oriented Programming](#object-oriented-programming)
  * [1. What is the purpose of the equals() and hashCode() methods in Java? How are they related?](#1-what-is-the-purpose-of-the-equals---and-hashcode---methods-in-java--how-are-they-related-)
  * [2. What is a static nested class in Java? How is it different from an inner class?](#2-what-is-a-static-nested-class-in-java--how-is-it-different-from-an-inner-class-)
  * [3. How does the `final` keyword work in Java? Explain its usage with variables, methods, and classes.](#3-how-does-the--final--keyword-work-in-java--explain-its-usage-with-variables--methods--and-classes)

## Object oriented Programming

### 1. What is the purpose of the equals() and hashCode() methods in Java? How are they related?

- equals() method: The equals() method is used to compare two objects for equality. It is defined in the Object class and can be overridden in custom classes to provide a meaningful comparison based on the object's state. The general contract for the equals() method includes the following guidelines:
  - Reflexive: x.equals(x) should return true for any non-null reference x.
  - Symmetric: If x.equals(y) returns true, then y.equals(x) should also return true.
  - Transitive: If x.equals(y) returns true and y.equals(z) returns true, then x.equals(z) should also return true.
  - Consistent: The result of equals() should not change if the objects are not modified.
  - Null Handling: x.equals(null) should return false for any non-null reference x.
- hashCode() method: The hashCode() method is used to generate a unique hash code for an object. It is also defined in the Object class and can be overridden in custom classes to provide a hash code based on the object's state. The general contract for the hashCode() method includes the following guidelines:
  - Consistency: The same object should always return the same hash code, as long as its state doesn't change.
  - Equality Implies Same Hash Code: If two objects are equal according to the equals() method, their hash codes should be the same.
  - Unequal Objects Can Have Same Hash Code: It is possible for two different objects to have the same hash code, although it is desirable to minimize such collisions to improve performance.
- The hashCode() method is used in data structures like hash-based collections (e.g., HashSet, HashMap) to efficiently store and retrieve objects based on their hash codes. It is generally recommended to override hashCode() whenever equals() is overridden to maintain consistency.
- When overriding equals(), it is good practice to override hashCode() as well to ensure correct behavior when using objects in collections that rely on hash-based operations.

```
   @Override
   public boolean equals(Object o) {
       if (this == o) return true;
       if (o == null || getClass() != o.getClass()) return false;
       Employee employee = (Employee) o;
       return id == employee.id &&
               Objects.equals(name, employee.name) &&
               Objects.equals(department, employee.department);
   }

   @Override
   public int hashCode() {
       return Objects.hash(id, name, department);
   }
```

### 2. What is a static nested class in Java? How is it different from an inner class?

- **Inner Class** : Inner classes, also known as nested classes, are classes defined within another class in Java. They provide a way to logically group classes and improve encapsulation by keeping related classes together. Inner classes have access to the members (fields and methods) of the enclosing class, including private members, and can also access them directly.
- There are four types of inner classes in Java:

  - Non-static inner class (Member inner class):
    - Defined without the static keyword inside another class.
    - It has access to all members of the enclosing class, including private members.
    - Can be instantiated only with an instance of the enclosing class.
    - Can have its own fields, methods, and constructors.
    - Example: OuterClass.java
  - Static nested class:
    - Defined as a static class within another class.
    - It does not have access to the instance members of the enclosing class, only to static members.
    - Can be instantiated independently, without an instance of the enclosing class.
    - Can have its own fields, methods, and constructors.
    - Example: StaticNestedClass.java
  - Local inner class:
    - Defined within a method or block of code.
    - It is not accessible outside the scope of the method or block where it is defined.
    - It has access to all members of the enclosing class and local variables of the method or block (if they are final or effectively final).
    - Can have its own fields, methods, and constructors.
    - example: LocaLInner.java
  - Anonymous inner class:
    - A special type of local inner class that does not have a name.
    - Defined and instantiated at the same time.
    - It is often used for implementing interfaces or extending classes on-the-fly.
    - Can have its own fields, methods, and constructors, but they are typically not explicitly declared.
    - example: Anonymous.java

### 3. How does the `final` keyword work in Java? Explain its usage with variables, methods, and classes.


## Reference:
- https://ecotrust-canada.github.io/markdown-toc/
- 
