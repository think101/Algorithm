package main.com.think101.leetcode.Patterns.Trees.MinimumDepthOfBinaryTree;

import main.com.think101.leetcode.Patterns.Trees.TreeNode;

public class Solution {
    public int minDepth(TreeNode tn) {
        if(tn == null) return 0;

        if(tn.left == null && tn.right == null) return 1;

        int l = tn.left != null ? minDepth(tn.left) : Integer.MAX_VALUE;
        int r = tn.right != null ? minDepth(tn.right) : Integer.MAX_VALUE;

        return 1 + Math.min(l, r);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1, null, new TreeNode(3, new TreeNode(2), null));
        System.out.println(s.minDepth(root));
    }
}
