package main.com.think101.leetcode.Patterns.BackTrack.PathSumII;

import main.com.think101.leetcode.Patterns.Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root, targetSum, new ArrayList<>());

        return res;
    }

    private void helper(TreeNode root, int target, List<Integer> path) {
        if(root == null) return;
        if(root.val == target && root.left == null && root.right == null) {
            List<Integer> l = new ArrayList<>(path);
            l.add(root.val);
            res.add(l);
            return;
        }

        path.add(root.val);
        helper(root.left, target - root.val, path);
        helper(root.right, target - root.val, path);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        System.out.println(s.pathSum(root, 22));
    }
}
