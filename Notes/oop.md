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
The final keyword in Java is a non-access modifier that can be used with variables, methods, and classes. When a variable, method, or class is declared final, it cannot be changed.

Here's how the `final` keyword works in different contexts:

1. Final Variables:
  - When applied to a variable, the `final` keyword ensures that the variable's value cannot be changed once assigned.
  - Final variables must be initialized either at the time of declaration or within the constructor.
  - The value of a final variable is constant throughout its lifetime.
  - Example:
    ```java
    final int x = 10; // Final variable
    ```

2. Final Methods:
  - When applied to a method, the `final` keyword prevents the method from being overridden by subclasses.
  - Final methods retain their implementation in the superclass and cannot be modified in any subclass.
  - Final methods are commonly used for critical operations that should not be altered.
  - Example:
    ```java
    public class Parent {
        public final void doSomething() {
            // Method implementation
        }
    }
    ```

3. Final Classes:
  - When applied to a class, the `final` keyword prevents the class from being extended or subclassed.
  - Final classes cannot be inherited by other classes.
  - Final classes are typically used when you want to ensure that the class cannot be overridden or modified.
  - Example:
    ```java
    public final class MyFinalClass {
        // Class members and methods
    }
    ```

The `final` keyword provides important guarantees in Java, such as immutability, preventing method overriding, and prohibiting class inheritance. It allows you to define constants, enforce design decisions, and ensure the integrity of critical elements in your code.

Internally, the final keyword is implemented by the Java compiler. When the compiler sees a final variable, it generates code that ensures that the value of the variable cannot be changed. When the compiler sees a final method, it generates code that prevents the method from being overridden. When the compiler sees a final class, it generates code that prevents the class from being extended.

### 4. What is the difference between composition and inheritance? When would you prefer one over the other?

Inheritance and composition are both object-oriented programming (OOP) concepts that allow you to reuse code and create more complex objects. However, they differ in how they achieve this.

**Inheritance** is a "is-a" relationship, where one class inherits from another class. This means that the inheriting class inherits all of the properties and methods of the inherited class. For example, the Car class might inherit from the Vehicle class. This means that any Car object will also have all of the properties and methods of a Vehicle object.

**Composition** is a "has-a" relationship, where one class contains an instance of another class. This means that the containing class has access to the properties and methods of the contained class, but the contained class is not aware of the containing class. For example, the Car class might have a Engine property, which is an instance of the Engine class. The Engine class is not aware of the Car class, but the Car class can access the properties and methods of the Engine class.

Here are some of the key differences between inheritance and composition:
- Inheritance is a static relationship, while composition is a dynamic relationship. This means that the relationship between the inheriting and inherited classes is fixed at compile time, while the relationship between the containing and contained classes can change at runtime.
- Inheritance can lead to tight coupling, while composition can lead to loose coupling. This means that changes to the inherited class can affect the inheriting class, while changes to the contained class do not affect the containing class.
- Inheritance is typically used for code reuse, while composition is typically used for code modularization. This means that inheritance is used to reuse code that is common to multiple classes, while composition is used to break down a complex class into smaller, more manageable parts.

**When to choose between inheritance and composition:**
Inheritance can be a powerful tool for code reuse, but it can also lead to tight coupling and make it difficult to change the code. Composition can help to improve code modularity and make it easier to change the code, but it can also make the code more complex.

### 5.Explain the concept of polymorphism in Java. Provide an example demonstrating runtime polymorphism.
Polymorphism is a powerful feature of object-oriented programming (OOP) that allows you to write code that works with different types of objects in a way that is independent of their specific type. This can make your code more reusable and easier to maintain.

There are two main types of polymorphism in Java:
- Compile-time polymorphism: This is also known as static polymorphism or method overloading. It occurs when a method with the same name is defined in multiple classes, but with different signatures. The compiler can determine which method to call at compile time, based on the types of the arguments that are passed to the method.
```
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
    
    public double add(double a, double b) {
        return a + b;
    }
    
    public int add(int a, int b, int c) {
        return a + b + c;
    }
    
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        
        int result1 = calculator.add(5, 10);                 // Invokes the add(int a, int b) method
        double result2 = calculator.add(3.5, 2.5);           // Invokes the add(double a, double b) method
        int result3 = calculator.add(1, 2, 3);               // Invokes the add(int a, int b, int c) method
        
        System.out.println("Result 1: " + result1);          // Output: Result 1: 15
        System.out.println("Result 2: " + result2);          // Output: Result 2: 6.0
        System.out.println("Result 3: " + result3);          // Output: Result 3: 6
    }
}
```
- Run-time polymorphism: This is also known as dynamic polymorphism or method overriding. It occurs when a method with the same name is defined in a subclass, and the method in the subclass overrides the method in the superclass. The Java Virtual Machine (JVM) determines which method to call at runtime, based on the actual type of the object that the method is called on.
```
class Animal {
  void speak() {
    System.out.println("Animals make sounds.");
  }
}

class Dog extends Animal {
  @Override
  void speak() {
    System.out.println("Dogs bark.");
  }
}

class Cat extends Animal {
  @Override
  void speak() {
    System.out.println("Cats meow.");
  }
}

public class Polymorphism {
  public static void main(String[] args) {
    Animal animal = new Dog();
    animal.speak();

    animal = new Cat();
    animal.speak();
  }
}
```

### 6.  What is the `super` keyword in Java? How is it used in constructors and method overriding?
The super keyword in Java is used to refer to the superclass (parent class) of the current class. It provides a way to access and invoke superclass members, including fields, methods, and constructors. The super keyword is commonly used in constructors and method overriding.
- In Constructors: 
```
public class Parent {
    public Parent(int value) {
        // Superclass constructor
    }
}

public class Child extends Parent {
    public Child(int value) {
        super(value); // Invoke superclass constructor with 'value' argument
        // Subclass-specific code
    }
}
```
- In Method Overriding:
```
public class Parent {
    public void doSomething() {
        // Superclass implementation
    }
}

public class Child extends Parent {
    @Override
    public void doSomething() {
        super.doSomething(); // Invoke superclass method
        // Subclass-specific code
    }
}
```

### 7.  What is the Java interface? How is it different from an abstract class?
In Java, an interface is a reference type that defines a set of methods that a class must implement. It specifies a set of abstract methods (methods without a body) that a class must define when it implements the interface. An interface can also declare constants and provide default method implementations starting from Java 8.Below are difference with abstract class.
- Method Implementation: All methods in an interface are abstract by default and require concrete implementation in the implementing class. In an abstract class, you can have abstract methods that require implementation in the subclass as well as non-abstract methods with implementations.
- Multiple Inheritance: A class can implement multiple interfaces, but it can only inherit from a single abstract class.
- Fields: Interfaces can only define constants (static final fields) and cannot have instance variables. Abstract classes can have instance variables, constructors, and other non-abstract members.
- Usage: Interfaces are used to define contracts and provide a way to achieve multiple inheritance of type. Abstract classes are used to provide a common base with shared behavior and partial implementations for subclasses.

### 8. Interface in java 8 
In Java 8, interfaces were enhanced to support the addition of default methods and static methods. This addition was made to provide backward compatibility for existing implementations while allowing interfaces to evolve without breaking the implementing classes. Let's explore these new features:
- Default Methods:
  - A default method is a method defined in an interface with a default implementation.
  - Default methods are declared using the default keyword before the method signature.
  - Default methods provide a default implementation that can be used by implementing classes. Implementing classes have the option to override the default method if needed.
  - Default methods allow adding new functionality to existing interfaces without breaking the implementing classes.
```
  public interface MyInterface {
    default void myMethod() {
     System.out.println("Default implementation of myMethod");
    }
  }
```
- Static Methods:
  - Static methods can now be defined in interfaces.
  - Static methods in interfaces are similar to static methods in classes, except that they cannot be overridden.
  - Static methods provide utility methods or helper methods that can be directly called using the interface name, without the need for an instance of the implementing class.
```
public interface MyInterface {
    static void myStaticMethod() {
        System.out.println("Static method in an interface");
    }
}
```
- Default and Static Method Conflict Resolution:
```
public interface InterfaceA {
    default void myMethod() {
        System.out.println("Default implementation from InterfaceA");
    }
}

public interface InterfaceB {
    default void myMethod() {
        System.out.println("Default implementation from InterfaceB");
    }
}

public class MyClass implements InterfaceA, InterfaceB {
    @Override
    public void myMethod() {
        InterfaceA.super.myMethod(); // Invoke default implementation from InterfaceA
    }
}
```
### 9. What are the access modifiers in Java (e.g., `public`, `private`, `protected`)? Explain their differences and use cases.
In Java, access modifiers are keywords used to specify the accessibility or visibility of classes, methods, variables, and constructors. There are four access modifiers in Java:

1. **`public`:**
  - The `public` modifier provides the highest level of accessibility.
  - Public members can be accessed from any other class, regardless of the package or subclass.
  - Example: A public class, method, or field can be accessed from any other class.

2. **`private`:**
  - The `private` modifier provides the most restrictive level of accessibility.
  - Private members can only be accessed within the same class.
  - Private members are not accessible from any other class, including subclasses and classes in different packages.
  - Example: A private method or field can only be accessed within the same class.

3. **`protected`:**
  - The `protected` modifier provides accessibility within the same package and to subclasses (even if they are in different packages).
  - Protected members are not accessible to classes in different packages unless they are subclasses.
  - Example: A protected method or field can be accessed within the same package or by a subclass in a different package.

4. **Default (no modifier):**
  - If no access modifier is specified, the default access modifier is applied.
  - Default members are accessible within the same package (package-private).
  - Default members are not accessible from classes in different packages, even if they are subclasses.
  - Example: A class, method, or field without any access modifier can be accessed within the same package.

Here are some use cases for different access modifiers:

- `public`:
  - Use `public` for classes, methods, and fields that need to be accessed from anywhere in the application or by other modules.
  - For example, a public class can be used by other classes to create instances or invoke its methods.

- `private`:
  - Use `private` for methods and fields that should only be accessed within the same class and not exposed to other classes.
  - For example, private helper methods or instance variables can be used to encapsulate internal logic or data.

- `protected`:
  - Use `protected` for methods and fields that need to be accessed within the same package and also by subclasses in different packages.
  - For example, a protected method can be overridden by a subclass to provide a specialized implementation.

- Default (no modifier):
  - Use the default access modifier for classes, methods, and fields that should only be accessible within the same package.
  - For example, package-private classes or methods can be used to group related functionality within a package.

### 10. 

## Reference:
- https://ecotrust-canada.github.io/markdown-toc/
- 
