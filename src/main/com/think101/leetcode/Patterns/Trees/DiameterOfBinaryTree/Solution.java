package main.com.think101.leetcode.Patterns.Trees.DiameterOfBinaryTree;

import main.com.think101.leetcode.Patterns.Trees.TreeNode;

public class Solution {
    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);

        return res;
    }

    private int maxDepth(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        res = Math.max(res, (root.left != null ? left + 1 : 0) +
                (root.right != null ? right + 1 : 0));

        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(s.diameterOfBinaryTree(root));
    }
}

