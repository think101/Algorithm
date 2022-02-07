package main.com.think101.leetcode.SymmetricTree;

public class Solution {

    // need improvement
    public boolean isSymmetric(TreeNode root) {
        TreeNode[] l = new TreeNode[2];
        l[0] = root.left;
        l[1] = root.right;

        return checkLevel(l);
    }

    private boolean checkLevel(TreeNode[] list) {
        if(list.length == 0) return true;

        TreeNode[] l = new TreeNode[list.length * 2];

        int lend = 0, rend = list.length - 1;
        boolean processed = false;
        while(lend < rend) {
            TreeNode left = list[lend];
            TreeNode right = list[rend];

            if(left == null && right == null) {
                lend++;
                rend--;
                continue;
            }


            if(left == null || right == null || left.val != right.val)
                return false;

            l[lend * 2] = left.left;
            l[lend * 2 + 1] = left.right;
            l[rend * 2] = right.left;
            l[rend * 2 + 1] = right.right;

            processed = true;

            lend++;
            rend--;
        }

        if(!processed)
            return true;

        return checkLevel(l);
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
