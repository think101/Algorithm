package main.com.think101.leetcode.Grind75.LRUCache;

import java.util.HashMap;

public class LRUCache {
    private final int capacity;
    private final Node left;
    private final Node right;
    private HashMap<Integer, Node> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.next = this.right;
        this.right.prev = this.left;
        this.cache = new HashMap<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        remove(key);
        add(key);

        return cache.get(key).value;
    }

    // remove key's node in the 2-direction linked list
    public void remove(int key) {
        Node n = cache.get(key);
        n.prev.next = n.next;
        n.next.prev = n.prev;
        n.next = n.prev = null;
    }

    // add key's node to the most right side
    public void add(int key) {
        Node n = cache.get(key);
        right.prev.next = n;
        n.prev = right.prev;
        right.prev = n;
        n.next = right;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.get(key).value = value;
            remove(key);
            add(key);
            return;
        }

        Node n = new Node(key, value);
        cache.put(key, n);
        add(key);

        if (cache.keySet().size() > capacity) {
            Node r = left.next;
            remove(r.key);
            cache.remove(r.key);
        }
    }

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
