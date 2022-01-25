package main.com.think101.leetcode.RemoveNthNodeFromEndofList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = head;
        ListNode current = head;
        ListNode next = head;

        int steps = 0;
        while(steps < n-1) {
            next = next.next;
            steps++;
        }

        if(next.next != null) {
            next = next.next;
            current = current.next;
        }


        while(next != null && next.next != null) {
            next = next.next;
            current = current.next;
            prev = prev.next;
        }

        if(current == head)
            return head.next;

        prev.next = current.next;

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


// edge cases not easy to handle well
