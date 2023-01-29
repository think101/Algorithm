package main.com.think101.leetcode.Patterns.DP.TargetSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionDP {
    Map<List<Integer>, Integer> dp = new HashMap<>();

    public int findTargetSumWays(int[] nums, int target) {
        bt(nums, 0, target);

        return dp.getOrDefault(Arrays.asList(0, target), 0);
    }

    private int bt(int[] nums, int i, int target) {
        if(dp.containsKey(Arrays.asList(i, target))) return dp.get(Arrays.asList(i, target));

        if(i == nums.length) {
            return target == 0 ? 1 : 0;
        }

        int t = 0;
        t += bt(nums, i + 1, target + nums[i]);
        t += bt(nums, i + 1, target - nums[i]);

        dp.put(Arrays.asList(i, target), t);

        return t;
    }

    public static void main(String[] args) {
        SolutionDP s = new SolutionDP();
        System.out.println(s.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
