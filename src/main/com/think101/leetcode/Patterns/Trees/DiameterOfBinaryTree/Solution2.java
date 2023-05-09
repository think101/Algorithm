package main.com.think101.leetcode.Patterns.Trees.DiameterOfBinaryTree;

import main.com.think101.leetcode.Patterns.Trees.TreeNode;

public class Solution2 {

    public int diameterOfBinaryTree(TreeNode root) {
        int[] r = helper(root);

        return r[1];
    }

    // a[0] max height a[1] current max diameter
    private int[] helper(TreeNode node) {
        if(node == null) return new int[]{-1, 0};

        int[] left = helper(node.left);
        int[] right = helper(node.right);

        int maxHeight = Math.max(left[0], right[0]) + 1;
        int currMaxD = Math.max(Math.max(left[1], right[1]), left[0] + right[0] + 2);

        return new int[]{maxHeight, currMaxD};
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(s.diameterOfBinaryTree(root));
    }
}
