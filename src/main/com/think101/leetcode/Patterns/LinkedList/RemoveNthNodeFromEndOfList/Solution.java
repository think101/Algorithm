package main.com.think101.leetcode.Patterns.LinkedList.RemoveNthNodeFromEndOfList;

import main.com.think101.leetcode.Patterns.LinkedList.ListNode;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode l = dummy, r = dummy;
        for(int i = 0; i < n; i++) {
            r = r.next;
        }

        while (r.next != null) {
            r = r.next;
            l = l.next;
        }

        l.next = l.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode l = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode r = s.removeNthFromEnd(l, 2);
        while(r != null) {
            System.out.println(r.val);
            r = r.next;
        }
    }
}
