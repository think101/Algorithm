package main.com.think101.leetcode.OddEvenLinkedList;

public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;

        ListNode evenHead = head.next;
        ListNode oddCurrent = head, evenCurrent = head.next;
        while (evenCurrent != null && evenCurrent.next != null) {
            oddCurrent.next = evenCurrent.next;
            evenCurrent.next = evenCurrent.next.next;

            oddCurrent = oddCurrent.next;
            evenCurrent = evenCurrent.next;
        }

        oddCurrent.next = evenHead;
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
