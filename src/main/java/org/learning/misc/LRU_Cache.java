package org.learning.misc;

import java.util.*;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

interface ApiData<T> {
    public T getAPiData();
}

class ExternalApi implements ApiData<String> {
    public String getAPiData() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        return "Dummy value";
    }
}

class Cache<K, V> {
    private Map<K, V> dataMap;
    private ApiData<V> apiData;
    private final int MAX_KEYS;
    private final ReadWriteLock lock;
    public Cache(ApiData<V> apiData, int maxKeys) {
        this.MAX_KEYS = maxKeys;
        this.apiData = apiData;
        lock = new ReentrantReadWriteLock();
        this.dataMap = new LinkedHashMap<>(MAX_KEYS, 0.75f, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > MAX_KEYS;
            }
        };
    }

    public void put(K key, V value) {
        lock.writeLock().lock();
        try {
            dataMap.put(key, value);
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new RuntimeException("Exception in adding/updating a cache");
        } finally {
            lock.writeLock().unlock();
        }
    }

    public V get(K key) {
        lock.readLock().lock();
        V data;
        try {
            if (dataMap.containsKey(key)) {
                data = dataMap.get(key);
                return data;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Exception in fetching a cache");
        } finally {
            lock.readLock().unlock();
        }

        lock.writeLock().lock();
        try {
            data = apiData.getAPiData();
            dataMap.put(key, data);
            return data;
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new RuntimeException("Exception in fetching and updating data");
        } finally {
            lock.writeLock().unlock();
        }
    }
}

public class LRU_Cache {
    public static void main(String[] args) {
        ApiData<String> apiData = new ExternalApi();
        Cache<String, String> cache = new Cache<>(apiData,4);

        cache.put("A", "1");
        cache.put("B", "some value");
        cache.put("C", "some value 2");
        cache.put("D", "some value 3");
        cache.put("E", "some value 3");
        cache.put("F", "some value 3");
        cache.put("G", "some value 3");

        String value = cache.get("G");
        System.out.println(value);

        System.out.println(cache.get("G"));
    }
}
