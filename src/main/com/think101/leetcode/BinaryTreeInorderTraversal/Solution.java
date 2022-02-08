package main.com.think101.leetcode.BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null)
            return new ArrayList<>();

        List<Integer> left = inorderTraversal(root.left);
        left.add(root.val);
        left.addAll(inorderTraversal(root.right));

        return left;
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
