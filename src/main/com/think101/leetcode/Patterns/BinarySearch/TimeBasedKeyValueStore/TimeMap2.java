package main.com.think101.leetcode.Patterns.BinarySearch.TimeBasedKeyValueStore;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap2 {
    Map<String, List<Pair<Integer, String>>> store;

    public TimeMap2() {
        store = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!store.containsKey(key)) {
            store.put(key, new ArrayList<>());
        }

        store.get(key).add(new ImmutablePair<>(timestamp, value));
    }

    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> m = store.get(key);

        if(m != null) {
            int l = 0, r = m.size() - 1;
            while(l <= r) {
                int middle = (l + r) / 2;
                if(m.get(middle).getLeft() == timestamp) return m.get(middle).getRight();
                else if(m.get(middle).getLeft() < timestamp) l = middle + 1;
                else r = middle - 1;
            }

            if(r >= 0 && m.get(r).getLeft() < timestamp) return m.get(r).getRight();
        }

        return "";
    }

    public static void main(String[] args) {
        TimeMap2 s = new TimeMap2();
        s.set("foo", "bar", 1);
        System.out.println(s.get("foo", 1));
        System.out.println(s.get("foo", 3));
        s.set("foo", "bar2", 4);
        System.out.println(s.get("foo", 4));
        System.out.println(s.get("foo", 5));
    }
}
