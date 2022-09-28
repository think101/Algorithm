package main.com.think101.leetcode.Patterns.Trees.KthSmallestElementinBST;

import main.com.think101.leetcode.Patterns.Trees.TreeNode;

public class Solution {
    int cnt = 0;
    int res = -1;

    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return res;
    }

    private void helper(TreeNode root, int k) {
        if(root == null) return;

        helper(root.left, k);
        cnt++;
        if(cnt == k){
            res = root.val;
            return;
        }
        helper(root.right, k);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        System.out.println(s.kthSmallest(root, 3));
    }
}