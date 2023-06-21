package org.learning.strm;

import java.util.List;
import java.util.stream.Collectors;

public class DublicateChar {
    public static void main(String[] args) {
        String str = "hello world";
        List<Character> duplicateCharacters = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .map(e -> e.getKey())
                .collect(Collectors.toList());

        System.out.println("Duplicate characters: " + duplicateCharacters);

    }
}
