package main.com.think101.leetcode.ReorderList;

public class Solution {
    public void reorderList(ListNode head) {
        helper(head);
    }

    private ListNode helper(ListNode head) {
        if(head.next == null || head.next.next == null)
            return head;

        ListNode left = head, right = head.next;
        while(right.next != null) {
            left = left.next;
            right = right.next;
        }

        ListNode tmp = head.next;
        head.next = right;
        left.next = null;

        right.next = helper(tmp);

        return head;

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
