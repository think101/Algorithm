package main.com.think101.leetcode.Patterns.LinkedList.LinkedListCycle;

import main.com.think101.leetcode.Patterns.LinkedList.ListNode;

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = new ListNode(0);
        fast.next = head;
        ListNode slow = new ListNode(0);
        slow.next = head;

        while(true) {
            for(int i = 0; i < 2; i++) {
                fast = fast.next;
                if(fast == slow) return true;
                else if(fast == null) return false;
            }

            slow = slow.next;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode l = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(s.hasCycle(l));
    }
}
