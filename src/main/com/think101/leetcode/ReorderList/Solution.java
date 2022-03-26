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


    public void reorderList2(ListNode head) {
        ListNode left = head, right = head;
        while(right != null && right.next != null) {
            left = left.next;
            right = right.next.next;
        }

        ListNode rightPart = reverse(left.next);
        left.next = null;
        merge(head, rightPart);
    }

    private ListNode reverse(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode current = head, next = head.next;
        head.next = null;
        while(next != null) {
            ListNode tmp = next.next;
            next.next = current;
            current = next;
            next = tmp;
        }

        return current;
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode result = new ListNode(-1, null);
        ListNode current = result;

        while(node1 != null || node2 != null) {
            if(node1 != null) {
                current.next = node1;
                node1 = node1.next;
                current = current.next;
            }

            if(node2 != null){
                current.next = node2;
                node2 = node2.next;
                current = current.next;
            }
        }

        return result.next;
    }
}
