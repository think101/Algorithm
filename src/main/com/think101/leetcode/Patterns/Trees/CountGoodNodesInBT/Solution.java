package main.com.think101.leetcode.Patterns.Trees.CountGoodNodesInBT;

import main.com.think101.leetcode.Patterns.Trees.TreeNode;

public class Solution {
    int res = 0;

    public int goodNodes(TreeNode root) {
        helper(root, root.val);
        return res;
    }

    private void helper(TreeNode root, int max) {
        if(root == null) return;

        if(root.val >= max) res++;

        int m = Math.max(root.val, max);
        helper(root.left, m);
        helper(root.right, m);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);
        System.out.println(s.goodNodes(root));
    }
}