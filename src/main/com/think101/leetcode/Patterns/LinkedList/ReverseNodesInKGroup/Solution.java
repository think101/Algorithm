package main.com.think101.leetcode.Patterns.LinkedList.ReverseNodesInKGroup;

import main.com.think101.leetcode.Patterns.LinkedList.ListNode;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode[] kGroup = new ListNode[k];
        ListNode dummy = new ListNode(0, head);
        ListNode curr = head, currEnd = dummy;

        while(true) {

            int cnt = 0;
            while(curr != null && cnt < k) {
                kGroup[cnt++] = curr;
                curr = curr.next;
            }

            if(cnt < k)  {
                if(cnt > 0) currEnd.next = kGroup[0];

                break;
            }
            ListNode nextCurr = curr == null ? null : curr.next;

            // found a k group, reverse it
            for(int i = k - 1; i > 0; i--) {
                kGroup[i].next = kGroup[i-1];
            }
            currEnd.next = kGroup[k - 1];
            currEnd = kGroup[0];
            curr = nextCurr;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode res = s.reverseKGroup(head, 2);
        while(res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
