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
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    public TreeNode buildTree(int[] preorder, int lp, int rp, int[] inorder, int li, int ri) {
        if(lp > rp)
            return null;
        if(lp == rp)
            return new TreeNode(preorder[lp]);

        int index = -1;
        for(int i=li; i<=ri; i++){
            if(inorder[i] == preorder[lp]) {
                index =i;
                break;
            }
        }
        int leftSize = index-li;

        TreeNode result = new TreeNode(preorder[lp]);
        result.left = buildTree(preorder, lp+1, lp+leftSize, inorder, li, index);
        result.right = buildTree(preorder, lp+1+leftSize, rp, inorder, index+1, ri);

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
