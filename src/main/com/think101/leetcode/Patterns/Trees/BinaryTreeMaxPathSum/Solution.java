package main.com.think101.leetcode.Patterns.Trees.BinaryTreeMaxPathSum;

import main.com.think101.leetcode.Patterns.Trees.TreeNode;

public class Solution {
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);

        return res;
    }

    // int[2]
    // int[0] is max path sum connecting two childs
    // int[1] is max path sum connection one child
    private int[] helper(TreeNode root) {
        if(root == null) return new int[]{0, 0};

        int[] left = helper(root.left);
        int[] right = helper(root.right);

        int connect1 = Math.max(root.val, root.val + Math.max(left[1], right[1]));
        int connect2 = Math.max(root.val, root.val + left[1] + right[1]);

        res = Math.max(res, Math.max(connect1, connect2));

        return new int[]{connect2, connect1};
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(s.maxPathSum(root));
    }
}