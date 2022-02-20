package main.com.think101.leetcode.Search2DMatrixII;

public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        // find target column
        int targetColumn = findInsertPosition(matrix[row-1], 0, col-1, target);

        for (int[] ints : matrix) {
            if (ints[0] > target || ints[col - 1] < target)
                continue;

            int findT = findInsertPosition(ints, targetColumn, col - 1, target);
            if (findT != -1 && ints[findT] == target)
                return true;
        }

        return false;

    }


    // returns res;
    // target >= nums[res];
    private int findInsertPosition(int[] nums, int l, int r, int target) {
        if(target <= nums[l])
            return l;
        else if(target >= nums[r])
            return r;

        while(true) {
            int m = (l+r+1)/2;
            if(m==l || m==r)
                return l;

            if(nums[m] == target)
                return m;
            else if(nums[m]>target) {
                r = m;
            }
            else
                l = m;
        }
    }
}
