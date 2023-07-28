package org.learning.generic;

import java.util.HashMap;
import java.util.Map;


interface Unique<T>{
    public int firstUnique(T[] arr);
}

class UniqueImpl<T> implements Unique<T>{
    private Map<T, Integer> map;
    public UniqueImpl() {
        map = new HashMap<>();
    }
    @Override
    public int firstUnique(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            T key = arr[i];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}

public class GetFirstUniqueue {

    public static void main(String[] args) {

        UniqueImpl<Character> characterUnique = new UniqueImpl<>();

        Character[] characters = {'a', 'b', 'a', 'b', 'c', 'd'};

        int ans = characterUnique.firstUnique(characters);
        System.out.println(ans);

        Integer[] integerList = {1, 2, 1, 2, 4, 5, 6, 7};
        UniqueImpl<Integer> integerUnique = new UniqueImpl<>();

        int ans2 = integerUnique.firstUnique(integerList);
        System.out.println(ans2);

    }
}
