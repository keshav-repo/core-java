1. How to Create a Thread-Safe ConcurrentHashSet in Java?
- ConcurrentHashSet can be created by using ConcurrentHashMap as it allows us to use keySet(default value) and newKeySet() methods to return the Set, which happens to be a proper Set.
```
    ConcurrentHashMap<String, Boolean> map = new ConcurrentHashMap<>();
    Set<String> concurrentMap = map.newKeySet();
    concurrentMap.add("456");
    concurrentMap.add("789");
    concurrentMap.add("101112");
```
2.   