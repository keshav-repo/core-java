package org.learning.lambda;

import java.util.*;
import java.util.stream.Collectors;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class GroupingByExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 25),
                new Person("David", 30),
                new Person("Emma", 25)
        );

        // Grouping people by age, calculating average age for each group
        Map<Integer, Double> averageAgeByGroup = people.stream()
                .collect(Collectors.groupingBy(
                        Person::getAge, // Classifier function
                        TreeMap::new,   // Map factory, creating a TreeMap
                        Collectors.averagingDouble(Person::getAge) // Downstream collector, calculating average age
                ));

        // Print the result
        averageAgeByGroup.forEach((age, average) ->
                System.out.println("Average age for age " + age + " is " + average));
    }
}
