class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            if(targetSum == 0)
                return true;
            else{
                return false;
            }
        }
        
        if(targetSum == 0)
            return false;
        
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
