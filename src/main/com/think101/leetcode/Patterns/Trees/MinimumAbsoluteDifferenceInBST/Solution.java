package main.com.think101.leetcode.Patterns.Trees.MinimumAbsoluteDifferenceInBST;

import main.com.think101.leetcode.Patterns.Trees.TreeNode;

public class Solution {
    int res = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        helper(root);

        return res;
    }

    private int[] helper(TreeNode node) {
        if(node == null) return new int[]{-1, -1};

        int[] left = helper(node.left);
        int[] right = helper(node.right);

        int min = left[0] != -1 ? left[0] : node.val;
        int max = right[1] != -1 ? right[1] : node.val;

        if(left[1] != -1) res = Math.min(res, node.val - left[1]);
        if(right[0] != -1) res = Math.min(res, right[0] - node.val);

        return new int[]{min, max};
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1, null, new TreeNode(3, new TreeNode(2), null));
        System.out.println(s.getMinimumDifference(root));
    }
}
