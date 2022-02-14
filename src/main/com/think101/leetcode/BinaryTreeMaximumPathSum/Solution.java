package main.com.think101.leetcode.BinaryTreeMaximumPathSum;

public class Solution {
    public int maxPathSum(TreeNode root) {
        int[] result =  maxPathSumHelper(root);
        return result[1];
    }

    // return [maxPathSumWithRoot, maxPathSum]
    // for maxPathSumWithRoot, it must contain the root and only one child can be used
    public int[] maxPathSumHelper(TreeNode root) {
        if(root.left == null && root.right == null) {
            return new int[]{root.val, root.val};
        }

        int[] left = new int[2];
        left[0] = left[1] = Integer.MIN_VALUE;
        if(root.left != null) {
            int[] l = maxPathSumHelper(root.left);
            left[0] = Math.max(l[0] + root.val, root.val);
            left[1] = Math.max(l[1], left[0]);
        }

        int[] right = new int[2];
        right[0] = right[1] = Integer.MIN_VALUE;
        if(root.right != null) {
            int[] r = maxPathSumHelper(root.right);
            right[0] = Math.max(r[0] + root.val, root.val);
            right[1] = Math.max(r[1], right[0]);
        }

        int[] result = new int[2];
        result[0] = Math.max(left[0], right[0]);
        result[1] = Math.max(left[1], Math.max(right[1], left[0]+right[0]-root.val));

        return result;
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