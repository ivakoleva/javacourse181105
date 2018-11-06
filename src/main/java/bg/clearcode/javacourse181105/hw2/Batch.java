package bg.clearcode.javacourse181105.hw2;

import java.util.HashMap;

public class Batch<K, V> {
    final private HashMap<K, V> hashMap;

    public Batch(final int initialCapacity) {
        hashMap = new HashMap<>(initialCapacity);
    }

    public int size() {
        return hashMap.size();
    }

    public boolean isEmpty() {
        return hashMap.isEmpty();
    }

    public V get(Object key) {
        return hashMap.get(key);
    }

    public V put(K key, V value) {
        return hashMap.put(key, value);
    }

    @Override
    public String toString() {
        return hashMap.toString();
    }
}
