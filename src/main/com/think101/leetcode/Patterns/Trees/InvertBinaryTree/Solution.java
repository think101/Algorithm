package main.com.think101.leetcode.Patterns.Trees.InvertBinaryTree;


import main.com.think101.leetcode.Patterns.Trees.TreeNode;

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return root;

        TreeNode newLeft = invertTree(root.right);
        TreeNode newRight = invertTree(root.left);

        root.left = newLeft;
        root.right = newRight;

        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        printTree(root);
        System.out.println();
        s.invertTree(root);
        printTree(root);
    }

    private static void printTree(TreeNode root) {
        if(root == null) return;
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}
