package main.com.think101.leetcode.ConstructBinaryTreeFromPreorderAndInorder;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] preorder = {3,9,20};
        int[] inorder = {9,3,20};
        TreeNode root = sol.buildTree(preorder, inorder);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0)
            return null;
        if(preorder.length==1)
            return new TreeNode(preorder[0]);

        int index = -1;
        for(int i=0; i<inorder.length; i++)
            if(inorder[i] == preorder[0])
                index =i;

        int[] preorderLeft = Arrays.copyOfRange(preorder, 1, 1+index);
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, index);

        int[] preorderRight = (1+index < preorder.length) ?
                Arrays.copyOfRange(preorder, 1+preorderLeft.length, preorder.length) : new int[0];
        int[] inorderRight = (1+index < inorder.length) ?
                Arrays.copyOfRange(inorder, 1+index, inorder.length) : new int[0];

        TreeNode result = new TreeNode(preorder[0]);
        result.left = buildTree(preorderLeft, inorderLeft);
        result.right = buildTree(preorderRight, inorderRight);

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
