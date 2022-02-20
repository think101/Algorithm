package main.com.think101.leetcode.Search2DMatrix;

public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        //find the row
        int[] c = new int[row+1];
        for(int i=0; i<row; i++)
            c[i] = matrix[i][0];
        c[row] = Integer.MAX_VALUE;
        int targetRow = findInsertPosition(c, target);


        if(targetRow == -1)
            return false;
        else if(matrix[targetRow][0] == target)
            return true;
        else {

            // find the target column
            int[] r = new int[col+1];
            System.arraycopy(matrix[targetRow], 0, r, 0, col);
            r[col] = Integer.MAX_VALUE;

            int targetColumn = findInsertPosition(r, target);
            return targetColumn != -1 && matrix[targetRow][targetColumn] == target;
        }
    }

    // returns res;
    // target >= nums[res];
    private int findInsertPosition(int[] nums, int target) {
        if(target < nums[0])
            return -1;

        int l=0, r=nums.length-1;
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
