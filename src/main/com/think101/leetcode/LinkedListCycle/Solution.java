package main.com.think101.leetcode.LinkedListCycle;

public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null ||  head.next == null)
            return false;

        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && slow != null) {
            fast = fast.next;
            if(fast == null)
                return false;
            fast = fast.next;
            slow = slow.next;

            if(fast == slow)
                return true;
        }

        return false;
    }

    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }
}
