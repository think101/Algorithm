package main.com.think101.leetcode.Patterns.BFS.MinDepthOfBT;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
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


public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;

        int res = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(q.size() > 0) {
            res++;

            int cnt = q.size();
            for(int i = 0; i < cnt; i++) {
                TreeNode tn = q.poll();

                assert tn != null;
                if(tn.right == null && tn.left == null)
                    return res;

                if(tn.right != null) q.add(tn.right);
                if(tn.left != null) q.add(tn.left);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5));
        System.out.println(new Solution().minDepth(root));
    }
}