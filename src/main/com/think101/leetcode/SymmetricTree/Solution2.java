package main.com.think101.leetcode.SymmetricTree;

public class Solution2 {
    public boolean isSymmetric(Solution.TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(Solution.TreeNode left, Solution.TreeNode right) {
        if(left == null && right == null)
            return true;
        else if(left == null || right == null)
            return false;
        else if(left.val != right.val)
            return false;

        return isSymmetric(left.right, right.left) && isSymmetric(left.left, right.right);

    }

}
