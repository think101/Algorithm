package main.com.think101.leetcode.Patterns.ArraysHashing.AverageSalary;

public class Solution {
    public double average(int[] salary) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int sum = 0;
        for(int s : salary) {
            max = Math.max(max, s);
            min = Math.min(min, s);

            sum += s;
        }

        sum -= max;
        sum -= min;

        return (double) sum / (salary.length - 2);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.average(new int[]{4000,3000,1000,2000}));
    }
}
