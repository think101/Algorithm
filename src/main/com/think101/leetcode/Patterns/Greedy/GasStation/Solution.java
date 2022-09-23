package main.com.think101.leetcode.Patterns.Greedy.GasStation;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = 0, sumCost = 0;
        for(int i = 0; i < gas.length; i++) {
            sumGas += gas[i];
            sumCost += cost[i];
        }

        if(sumGas < sumCost) return -1;

        int total = 0, res = 0;
        for(int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            if (total < 0) {
                total = 0;
                res = i + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(solution.canCompleteCircuit(gas, cost));
    }
}