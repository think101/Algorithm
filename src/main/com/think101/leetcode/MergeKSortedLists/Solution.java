package main.com.think101.leetcode.MergeKSortedLists;

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
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        ListNode helper = new ListNode(0);
        ListNode current = helper;

        while(true) {
            int index = -1;
            int min = Integer.MAX_VALUE;
            boolean allNull = true;

            for(int i=0; i<len; i++) {
                if(lists[i] != null) {
                    allNull = false;
                    if(lists[i].val < min) {
                        index = i;
                        min = lists[i].val;
                    }
                }
            }

            if(index != -1){
                current.next = lists[index];
                current = current.next;
                lists[index] = lists[index].next;
            }

            if(allNull)
                break;
        }

        return helper.next;

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
