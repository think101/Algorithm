package main.com.think101.leetcode.Patterns.Trees.ValidateBST;

import main.com.think101.leetcode.Patterns.Trees.TreeNode;

public class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode root, long min, long max) {
        if(root == null) return true;
        if(root.val <= min || root.val >= max) return false;

        return helper(root.left, min, root.val) &&  helper(root.right, root.val, max);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(s.isValidBST(root));
    }
}
