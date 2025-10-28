package ex5;

import java.util.*;

public class MapInverter {
    public static <K, V> Map<V, Collection<K>> invert(Map<K, V> map) {
        Map<V, Collection<K>> result = new HashMap<>();

        for (Map.Entry<K, V> entry : map.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();

            result.putIfAbsent(value, new ArrayList<>());
            result.get(value).add(key);
        }

        return result;
    }

    public static void main(String[] args) {
        Map<String, Integer> original = new HashMap<>();
        original.put("apple", 1);
        original.put("banana", 2);
        original.put("cherry", 1);
        original.put("date", 3);

        Map<Integer, Collection<String>> inverted = invert(original);

        System.out.println("Исходная Map: " + original);
        System.out.println("Инвертированная Map: " + inverted);
    }
}
