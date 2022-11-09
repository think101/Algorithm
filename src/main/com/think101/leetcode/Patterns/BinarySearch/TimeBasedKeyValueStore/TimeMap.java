package main.com.think101.leetcode.Patterns.BinarySearch.TimeBasedKeyValueStore;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeMap {
    Map<String, TreeMap<Integer, String>> store;

    public TimeMap() {
        store = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!store.containsKey(key)) {
            store.put(key, new TreeMap<>());
        }

        store.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> m = store.get(key);

        if(m != null) {
            Integer floor = m.floorKey(timestamp);

            if(floor != null) return m.get(floor);
        }

        return "";
    }

    public static void main(String[] args) {
        TimeMap s = new TimeMap();
        s.set("foo", "bar", 1);
        System.out.println(s.get("foo", 1));
        System.out.println(s.get("foo", 3));
        s.set("foo", "bar2", 4);
        System.out.println(s.get("foo", 4));
        System.out.println(s.get("foo", 5));
    }
}
