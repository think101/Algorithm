package main.com.think101.leetcode.Patterns.LinkedList.ReorderList;

import main.com.think101.leetcode.Patterns.LinkedList.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public void reorderList(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();

        while(head != null) {
            nodes.add(head);
            head = head.next;
        }

        ListNode[] nodeArray = nodes.toArray(new ListNode[0]);

        int l = 0, r = nodeArray.length - 1;
        while(r - l > 1 && l < nodeArray.length && r >= 0) {
            ListNode t = nodeArray[l].next;
            nodeArray[l].next = nodeArray[r];
            nodeArray[r].next = t;
            nodeArray[r-1].next = null;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode l = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        s.reorderList(l);
        print(l);

        ListNode l2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        s.reorderList(l2);
        print(l2);
    }

    private static void print(ListNode l) {
        while(l != null) {
            System.out.println(l.val);
            l = l.next;
        }
    }
}
