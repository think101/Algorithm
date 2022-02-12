package main.com.think101.leetcode.ConvertSortedArraytoBST;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {

        return sortedArrayToBST(nums, 0, nums.length-1);
    }


    private TreeNode sortedArrayToBST(int[] nums, int l, int r) {
        if(l > r ) return null;
        if(l == r) return new TreeNode(nums[l]);

        int m = l+(r+1-l)/2;                      // m = (l+r)/2;
        TreeNode result = new TreeNode(nums[m]);
        result.left = sortedArrayToBST(nums, l, m-1);
        result.right = sortedArrayToBST(nums, m+1, r);

        return result;

    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
