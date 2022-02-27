package main.com.think101.leetcode.SwapNodesInPairs;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p0 = dummy, p1 = p0.next, p2 = p1.next;

        while(p1 != null && p2 != null) {
            p1.next = p2.next;
            p2.next = p1;
            p0.next = p2;

            p0 = p1;
            p1 = p1.next;
            p2 = p1 == null ? null : p1.next;
        }

        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
