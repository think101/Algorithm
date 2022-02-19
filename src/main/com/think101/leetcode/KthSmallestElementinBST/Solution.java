package main.com.think101.leetcode.KthSmallestElementinBST;

public class Solution {

    public int kthSmallest(TreeNode root, int k) {
        int leftNodes = countNodes(root.left);

        if(leftNodes == k-1)
            return root.val;
        else if(leftNodes > k-1)
            return kthSmallest(root.left, k);
        else {
            return kthSmallest(root.right, k-leftNodes-1);
        }
    }

    private int countNodes(TreeNode root) {
        if(root == null) return 0;

        return countNodes(root.left) + 1 + countNodes(root.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
