package org.learning.collection;

public class CustomHashMap<K, V> {
    private Entry<K, V>[] table;
    private int capacity;
    public CustomHashMap() {
        this.capacity = 3;
        this.table = new Entry[this.capacity];
    }
    public void put(K key, V data) {
        if (key == null) {
            return;
        }
        int index = hash(key);
        // create new node
        Entry<K, V> entry = new Entry<>(key, data, null);

        if (table[index] == null) {
            table[index] = entry;
        } else {
            // check if already exist
            Entry<K, V> curr = table[index];
            while (curr.next != null) {
                if (curr.key.equals(key)) {
                    curr.value = data;
                    return;
                }
                curr = curr.next;
            }
            curr.next = entry;
        }
    }

    V get(K key) {
        int index = hash(key);
        Entry<K, V> head = table[index];
        while (head != null) {
            if(head.key.equals(key)){
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    int hash(K key) {
        int hashcode = key.hashCode();
        return Math.abs(hashcode % capacity);
    }

    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;
        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public Entry<K, V>[] getTable() {
        return table;
    }

    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();

        map.put("First", 1);
        map.put("Second", 2);
        map.put("Third", 3);
        map.put("Fourth", 4);
        map.put("Fifth", 5);
        map.put("Sixth", 6);
        map.put("Seventh", 7);

        System.out.println(map.get("Second"));

    }
}
