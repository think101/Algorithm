package main.com.think101.leetcode.Patterns.Stack.MaximalRectangle;

import java.util.Stack;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length, col = matrix[0].length;

        int res = 0;
        int[] heights = new int[col];

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(matrix[i][j] == '1') {
                    if(i-1 >= 0 && heights[j] > 0) heights[j]++;
                    else heights[j] = 1;
                }
                else {
                    heights[j] = 0;
                }
            }

            int a = largestRectangleArea(heights);
            res = Math.max(res, a);
        }

        return res;
    }

    private int largestRectangleArea(int[] heights) {
        Stack<int[]> s = new Stack<>();
        int res = 0;

        for(int i = 0; i < heights.length; i++) {
            int ind = i;
            while(s.size() > 0 && s.peek()[1] > heights[i]) {
                int[] elem = s.pop();
                ind = elem[0];
                res = Math.max(res, elem[1] * (i - elem[0]));
            }

            s.push(new int[]{ind, heights[i]});
        }

        // process elems remain in stack
        while(s.size() > 0) {
            int[] elem = s.pop();
            res = Math.max(res, elem[1] * (heights.length - elem[0]));
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maximalRectangle(new char[][]{
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'}
        }));
    }
}
