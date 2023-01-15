package main.com.think101.leetcode.Patterns.LinkedList.LRU;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class Node {
        private int key;
        private int value;
        private Node prev;
        private Node next;

        public Node(int key, int value, Node prev, Node next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node left;
    private Node right;
    private int capacity;
    Map<Integer, Node> cache = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.left = new Node(0, 0, null, null);
        this.right = new Node(0, 0, null, null);

        left.next = right;
        right.prev = left;
    }

    public int get(int key) {
        if(!cache.containsKey(key)) return -1;

        Node node = remove(key);
        add(key, node);

        return node.value;
    }

    public void put(int key, int value) {
        Node node = new Node(key, value, null, null);
        if(cache.containsKey(key)) {
            node = remove(key);
            node.value = value;
        }
        if(cache.size() >= capacity) {
            remove(left.next.key);
        }

        add(key, node);
    }

    private Node remove(int key) {
        Node node = cache.get(key);

        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;

        cache.remove(key);

        return node;
    }

    private void add(int key, Node node) {
        cache.put(key, node);

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
