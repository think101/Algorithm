package main.com.think101.leetcode.Patterns.BFS.AvgOfLevelsInBT;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        List<Double> res = new ArrayList<>();

        while(!q.isEmpty()) {
            double sum = 0;
            int count = q.size();
            for(int i = 0; i < count; i++){
                TreeNode node = q.poll();
                if(node != null) {
                    sum += node.val;

                    if(node.left != null)
                        q.add(node.left);
                    if(node.right != null)
                        q.add(node.right);
                }
            }

            res.add(sum / count);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode( 20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(s.averageOfLevels(root));
    }
}
