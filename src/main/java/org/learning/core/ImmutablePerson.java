package org.learning.core;

import java.util.Collections;
import java.util.List;
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
    public List<String> getHobbies() {
        return hobbies;
    }

    public static void main(String[] args) {

        List<String> hobbies = new ArrayList<>();
        hobbies.add("Cricket");
        hobbies.add("Football");
        hobbies.add("Basketball");
        ImmutablePerson immutablePerson = new ImmutablePerson("name", "40",hobbies );

       List<String> h =  immutablePerson.getHobbies();
       h.add("Badminton");



    }
}