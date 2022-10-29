package main.com.think101.leetcode.Patterns.Stack.LargestRectInHistogram;

import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] heights) {
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
        System.out.println(s.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}
