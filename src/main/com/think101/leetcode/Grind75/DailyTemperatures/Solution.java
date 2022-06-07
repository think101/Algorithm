package main.com.think101.leetcode.Grind75.DailyTemperatures;

import java.util.Arrays;

public class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        int[] stack = new int[T.length];
        int top = -1;
        for (int i = 0; i < T.length; i++) {
            while (top >= 0 && T[i] > T[stack[top]]) {
                res[stack[top]] = i - stack[top];
                top--;
            }
            stack[++top] = i;
        }
        return res;
    }


    public int[] dailyTemperatures_MINE(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        res[len-1] = 0;

        for(int i = len - 2; i >= 0; i--){
            if(temperatures[i+1] > temperatures[i]){
                res[i] = 1;
            }
            else {
                int ind = i+1;
                while(true) {
                    int t = res[ind];
                    if(t == 0){
                        ind = 0;
                        break;
                    }

                    ind = ind + t;
                    if(temperatures[ind] > temperatures[i]){
                        break;
                    }
                }

                res[i] = ind > i ? ind-i : 0;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(s.dailyTemperatures(temperatures)));

        temperatures = new int[]{30, 40, 50, 60};
        System.out.println(Arrays.toString(s.dailyTemperatures(temperatures)));

        temperatures = new int[]{30, 60, 90};
        System.out.println(Arrays.toString(s.dailyTemperatures(temperatures)));
    }
}
