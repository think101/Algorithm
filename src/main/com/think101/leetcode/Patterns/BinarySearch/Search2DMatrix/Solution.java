package main.com.think101.leetcode.Patterns.BinarySearch.Search2DMatrix;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] a = new int[matrix.length * matrix[0].length];
        int i = 0;
        for (int[] ints : matrix) {
            for (int c = 0; c < matrix[0].length; c++) {
                a[i++] = ints[c];
            }
        }

        return binarySearch(a, target);
    }

    private boolean binarySearch(int[] a, int t) {
        int l = 0, r = a.length - 1;

        while( l <= r) {
            int m = (l + r) / 2;
            if(a[m] == t) return true;
            else if (a[m] < t) l = m + 1;
            else r = m - 1;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.searchMatrix(new int[][]{
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
        }, 4));
    }
}
