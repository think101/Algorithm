package main.com.think101.leetcode.Patterns.LinkedList.ReverseLinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    ListNode(int x, ListNode next) { val = x; this.next = next; }
}

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head, next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode reversed = s.reverseList(head);
        while(reversed != null) {
            System.out.println(reversed.val);
            reversed = reversed.next;
        }
    }
}
