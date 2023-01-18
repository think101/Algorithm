package main.com.think101.leetcode.Patterns.LinkedList.MergeKSortedLists;

import main.com.think101.leetcode.Patterns.LinkedList.ListNode;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;

        while (true) {
            ListNode curr = null;
            int ind = -1;
            for(int i = 0; i < lists.length; i++) {
                ListNode node = lists[i];
                if(node != null && (curr == null || curr.val > node.val)) {
                    curr = node;
                    ind = i;
                }
            }

            if(curr == null) break;
            lists[ind] = curr.next;
            prev.next = curr;
            prev = curr;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
        lists[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
        lists[2] = new ListNode(2, new ListNode(6));
        ListNode res = s.mergeKLists(lists);
        while(res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
