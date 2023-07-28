## Difference between Abstract class and interface 

### 1. what is difference between Abstract class and interface in java 8 ?
- difference between an abstract class and an interface in Java 8 is the fact that an abstract class is a class and an interface is an interface. A class can have a state which can be modified by non-abstract methods but an interface cannot have the state because they can't have instance variables.
- The second difference is that an interface cannot have a constructor even in Java 8
- All methods of an interface were abstract but since Java 8 you can define non-abstract methods in the form of default and static methods inside the interface in Java.
- Interface fields are public, static and final by default. Interfaces still don’t support non-static and non-final variables. Interfaces can only have public, static and final variables. On the other hand, abstract class can have static as well as non-static and final as well as non-final variables. 
- All members of interfaces are public by default. Interfaces don’t support private and protected members. But, abstract classes support all type of members – private, protected and public members.
- A class can extend only one abstract class, but can implement multiple interfaces. Thus, a class can inherit multiple properties from multiple sources only through interfaces, not through abstract classes.


