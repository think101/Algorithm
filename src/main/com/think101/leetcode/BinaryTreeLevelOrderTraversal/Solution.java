package main.com.think101.leetcode.BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);

        printLevel(result, nodes);

        return result;
    }

    private void printLevel(List<List<Integer>> result, List<TreeNode> nodes) {
        if(nodes.size() == 0)
            return;

        List<Integer> current = new ArrayList<>();
        List<TreeNode> nextLevel = new ArrayList<>();
        for(TreeNode tNode : nodes) {
            if(tNode != null) {
                current.add(tNode.val);
                nextLevel.add(tNode.left);
                nextLevel.add(tNode.right);
            }
        }

        if(current.size() > 0)
            result.add(current);

        printLevel(result, nextLevel);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
