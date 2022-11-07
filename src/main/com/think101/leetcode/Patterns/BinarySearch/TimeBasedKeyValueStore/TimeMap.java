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
            Integer[] keys = m.keySet().toArray(new Integer[0]);
            int l = 0, r = keys.length;
            while(l <= r) {
                int middle = (l + r) / 2;
                if(keys[middle] == timestamp) return m.get(middle);
                else if(keys[middle] < timestamp) l = middle + 1;
                else r = middle - 1;
            }

            if(keys[r] < timestamp) return m.get(r);
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
