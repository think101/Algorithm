package main.com.think101.leetcode.LCAofBinaryTree;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val == p.val || root.val == q.val)
            return root;

        if(findNode(root.left, p) && findNode(root.left, q))
            return lowestCommonAncestor(root.left, p, q);
        else if(findNode(root.right, p) && findNode(root.right, q))
            return lowestCommonAncestor(root.right, p, q);
        else {
            return root;
        }
    }

    private boolean findNode(TreeNode root, TreeNode target) {
        if(root == null) return false;
        if(root.val == target.val)
            return true;


        return findNode(root.left, target) || findNode(root.right, target);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
