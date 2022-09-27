package main.com.think101.leetcode.Patterns.Trees.BalancedBinaryTree;

import main.com.think101.leetcode.Patterns.Trees.TreeNode;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class Solution {
    public boolean isBalanced(TreeNode root) {
        return helper(root).getKey();
    }

    Pair<Boolean, Integer> helper(TreeNode root) {
        if(root == null) return new ImmutablePair<>(true, 0);

        Pair<Boolean, Integer> left = helper(root.left);
        Pair<Boolean, Integer> right = helper(root.right);

        if(!left.getKey() || !right.getKey()) return new ImmutablePair<>(false, 0);

        return new ImmutablePair<>(Math.abs(left.getValue() - right.getValue()) <= 1,
                1 + Math.max(left.getValue(), right.getValue()));
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(s.isBalanced(root));
    }
}
