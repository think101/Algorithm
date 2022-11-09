package main.com.think101.leetcode.Patterns.BinarySearch.TimeBasedKeyValueStore;

import org.apache.commons.lang3.tuple.Pair;

public class TimeMap2 {
    Map<String, List<Pair<Integer, String>>> store;

    public TimeMap() {
        store = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!store.containsKey(key)) {
            store.put(key, new ArrayList<>());
        }

        store.get(key).add(new Pair<>(timestamp, value));
    }

    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> m = store.get(key);

        if(m != null) {
            int l = 0, r = m.size() - 1;
            while(l <= r) {
                int middle = (l + r) / 2;
                if(m.get(middle).first() == timestamp) return m.get(middle).second();
                else if(m.get(middle).first() < timestamp) l = middle + 1;
                else r = middle - 1;
            }

            if(r >= 0 && m.get(r).first() < timestamp) return m.get(r).second();
        }

        return "";
    }
}
