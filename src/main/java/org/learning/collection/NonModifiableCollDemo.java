package org.learning.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class NonModifiableCollDemo {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("Hello");
        words.add("World");

       Collection<String> s =  Collections.unmodifiableCollection(words);

        List<String> wordsUnmodifidable = Collections.unmodifiableList(words);
        wordsUnmodifidable.set(0, "something");

    }
}
