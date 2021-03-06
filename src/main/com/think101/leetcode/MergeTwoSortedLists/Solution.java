package main.com.think101.leetcode.MergeTwoSortedLists;

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(0);
        ListNode current = result;

        while(list1 != null || list2 != null) {
            if(list1 != null && list2 != null) {
                if(list1.val < list2.val ) {
                    current.next = list1;
                    current = list1;
                    list1 = list1.next;
                }
                else {
                    current.next = list2;
                    current = list2;
                    list2 = list2.next;
                }
            }
            else if(list1 != null) {
                current.next = list1;
                current = list1;
                list1 = list1.next;
            }
            else {
                current.next = list2;
                current = list2;
                list2 = list2.next;
            }
        }

        return result.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
