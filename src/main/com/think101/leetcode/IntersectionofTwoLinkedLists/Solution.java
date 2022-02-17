package main.com.think101.leetcode.IntersectionofTwoLinkedLists;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<>();

        ListNode t = headA;
        while (t != null) {
            visited.add(t);
            t = t.next;
        }

        t = headB;
        while (t != null) {
            if (visited.contains(t))
                return t;

            t = t.next;
        }

        return null;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
