package main.com.think101.leetcode.Patterns.LinkedList.MergeTwoSortedLists;

import main.com.think101.leetcode.Patterns.LinkedList.ListNode;

public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                curr.next = list1;
                curr = list1;
                list1 = list1.next;
            }
            else {
                curr.next = list2;
                curr = list2;
                list2 = list2.next;
            }

            curr.next = null;
        }

        if(list1 != null){
            curr.next = list1;
        }
        else if(list2 != null) {
            curr.next = list2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode merged = s.mergeTwoLists(list1, list2);
        while(merged != null) {
            System.out.println(merged.val);
            merged = merged.next;
        }
    }
}