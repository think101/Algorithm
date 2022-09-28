package main.com.think101.leetcode.Patterns.Trees.BTLevelOrderTraversal;

import main.com.think101.leetcode.Patterns.Trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null) queue.add(root);

        List<List<Integer>> res = new ArrayList<>();

        while(queue.size() > 0) {
            int len = queue.size();

            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < len; i++){
                TreeNode t = queue.poll();
                level.add(t.val);

                if(t.left != null) queue.add(t.left);
                if(t.right != null) queue.add(t.right);
            }

            res.add(level);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(s.levelOrder(root));
    }
}