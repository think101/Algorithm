package main.com.think101.leetcode.Patterns.LinkedList.MergeKSortedLists;

import main.com.think101.leetcode.Patterns.LinkedList.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution2 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for(ListNode node: lists) {
            if(node != null) pq.add(node);
        }

        while(pq.size() > 0) {
            ListNode n = pq.poll();
            curr.next = n;
            curr = n;
            n = n.next;

            if(n != null) pq.add(n);
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
        lists[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
        lists[2] = new ListNode(2, new ListNode(6));
        ListNode res = s.mergeKLists(lists);
        while(res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
