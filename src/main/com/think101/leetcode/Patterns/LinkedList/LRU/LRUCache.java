package main.com.think101.leetcode.Patterns.LinkedList.LRU;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class Node {
        private int key;
        private int value;
        private Node prev;
        private Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node left;
    private Node right;
    private int capacity;
    // map value is Node type is the key to resolve this problem
    // thread-safe use ConcurrentHashMap
    Map<Integer, Node> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();

        this.left = new Node(0, 0);
        this.right = new Node(0, 0);

        left.next = right;
        right.prev = left;
    }

    public int get(int key) {
        if(!cache.containsKey(key)) return -1;

        remove(key);
        add(key);

        return cache.get(key).value;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            cache.get(key).value = value;
            remove(key);
            add(key);
            return;
        }

        Node node = new Node(key, value);
        cache.put(key, node);
        add(key);

        if(cache.size() > capacity) {
            Node last = left.next;
            remove(last.key);
            cache.remove(last.key);
        }
    }


    private void remove(int key) {
        Node node = cache.get(key);

        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }

    private void add(int key) {
        Node node = cache.get(key);

        node.next = right;
        node.prev = right.prev;
        right.prev.next = node;
        right.prev = node;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
