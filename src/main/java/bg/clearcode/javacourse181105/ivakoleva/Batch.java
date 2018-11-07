package bg.clearcode.javacourse181105.ivakoleva;

import java.util.Collection;
import java.util.HashMap;

public class Batch<K, V> {
    public static final int BATCH_SIZE_DEFAULT = 5;
    final private HashMap<K, V> hashMap;

    public Batch() {
        this(BATCH_SIZE_DEFAULT);
    }

    public Batch(final int capacity) {
        hashMap = new HashMap<>(capacity);
    }

    public int size() {
        return hashMap.size();
    }

    public boolean isEmpty() {
        return hashMap.isEmpty();
    }

    public V get(K key) {
        return hashMap.get(key);
    }

    public V put(K key, V value) {
        return hashMap.put(key, value);
    }

    public Collection<V> values() {
        return hashMap.values();
    }

    public void printBatch() {
        hashMap.values().forEach(System.out::println);
    }

    @Override
    public String toString() {
        return hashMap.toString();
    }
}