package main.com.think101.leetcode.Patterns.Trees.SameTree;

import main.com.think101.leetcode.Patterns.Trees.TreeNode;

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        TreeNode subRoot = new TreeNode(1);
        subRoot.left = new TreeNode(2);
        subRoot.right = new TreeNode(3);
        System.out.println(s.isSameTree(root, subRoot));
    }
}