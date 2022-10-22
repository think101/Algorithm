package main.com.think101.leetcode.Patterns.Stack.DailyTemperatures;

import java.util.Stack;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < temperatures.length; i++) {
            if(stack.size() > 0 && temperatures[stack.peek()] < temperatures[i]) {
                while(true){
                    if(stack.size() == 0 || temperatures[stack.peek()] >= temperatures[i]) break;

                    int ind = stack.pop();
                    res[ind] = i - ind;
                }
            }

            stack.push(i);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] res = s.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        for(int i : res) {
            System.out.print(i + " ");
        }
    }
}
