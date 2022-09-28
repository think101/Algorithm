package main.com.think101.leetcode.Patterns.Trees.LowestCommonAncestorOfBST;

import main.com.think101.leetcode.Patterns.Trees.TreeNode;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val == p.val || root.val == q.val || (root.val > p.val && root.val < q.val)
                || (root.val < p.val && root.val > q.val))
            return root;

        if(root.val > p.val) return lowestCommonAncestor(root.left, p, q);
        else return lowestCommonAncestor(root.right, p, q);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        System.out.println(s.lowestCommonAncestor(root, new TreeNode(2), new TreeNode(8)).val);
    }
}