package main.com.think101.leetcode.Patterns.Trees.ConstructBinaryTreeFromPreorderAndInorderTraversal;

import main.com.think101.leetcode.Patterns.Trees.TreeNode;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;

        int val = preorder[0];

        int target = 0;
        for(int i = 0; i < inorder.length; i++ ) {
            if(inorder[i] == val) {
                target = i;
                break;
            }
        }

        int leftLen = target, rightLen = inorder.length - target - 1;
        int[] preLeft = new int[leftLen], inLeft = new int[leftLen];
        int[] preRight = new int[rightLen], inRight = new int[rightLen];

        for(int i = 0; i < leftLen; i++) {
            preLeft[i] = preorder[1+i];
            inLeft[i] = inorder[i];
        }

        for(int i = 0; i < rightLen; i++){
            preRight[i] = preorder[target + 1 + i];
            inRight[i] = inorder[target + 1 + i];
        }

        TreeNode root = new TreeNode(val);
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);

        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = s.buildTree(preorder, inorder);
        System.out.println(root.val);
    }
}