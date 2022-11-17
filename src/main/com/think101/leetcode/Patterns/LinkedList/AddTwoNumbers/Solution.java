package main.com.think101.leetcode.Patterns.LinkedList.AddTwoNumbers;

import main.com.think101.leetcode.Patterns.LinkedList.ListNode;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        int carry = 0;
        while(l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            int val = sum % 10;
            carry = sum / 10;
            ListNode n = new ListNode(val);

            curr.next = n;
            curr = n;

            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null ) {
            int sum = l1.val + carry;
            int val = sum % 10;
            carry = sum / 10;
            ListNode n = new ListNode(val);

            curr.next = n;
            curr = n;

            l1 = l1.next;
        }

        while(l2 != null ) {
            int sum = l2.val + carry;
            int val = sum % 10;
            carry = sum / 10;
            ListNode n = new ListNode(val);

            curr.next = n;
            curr = n;

            l2 = l2.next;
        }

        if(carry > 0) {
            curr.next = new ListNode(carry);
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode sum = s.addTwoNumbers(l1, l2);
        while(sum != null) {
            System.out.println(sum.val);
            sum = sum.next;
        }
    }
}
