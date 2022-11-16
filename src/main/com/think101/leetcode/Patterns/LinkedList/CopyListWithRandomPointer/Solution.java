package main.com.think101.leetcode.Patterns.LinkedList.CopyListWithRandomPointer;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


public class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        Map<Node, Node> oldToNew = new HashMap<>();

        Node newDummy = new Node(0);
        Node newHead = new Node(head.val);
        newDummy.next = newHead;
        oldToNew.put(head, newHead);

        while(head != null) {
            Node newNode = oldToNew.get(head);
            if(newNode == null) {
                newNode = new Node(head.val);
                oldToNew.put(head, newNode);
            }

            Node newNext = oldToNew.get(head.next);
            if(head.next != null && newNext == null) {
                newNext = new Node(head.next.val);
                oldToNew.put(head.next, newNext);
            }
            newNode.next = newNext;

            Node newRand = oldToNew.get(head.random);
            if(head.random != null && newRand == null) {
                newRand = new Node(head.random.val);
                oldToNew.put(head.random, newRand);
            }
            newNode.random = newRand;

            head = head.next;
        }

        return newDummy.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Node l = new Node(7);
        l.next = new Node(13);
        l.next.next = new Node(11);
        l.next.next.next = new Node(10);
        l.next.next.next.next = new Node(1);
        l.next.random = l;
        l.next.next.random = l.next.next.next.next;
        l.next.next.next.random = l.next.next;
        l.next.next.next.next.random = l;
        Node r = s.copyRandomList(l);
        while(r != null) {
            System.out.println(r.val);
            r = r.next;
        }
    }
}
