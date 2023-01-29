package main.com.think101.leetcode.Patterns.DP.TargetSum;

public class SolutionBT {
    int res = 0;

    public int findTargetSumWays(int[] nums, int target) {
        bt(nums, 0, target);

        return res;
    }

    private void bt(int[] nums, int i, int target) {
        if(i == nums.length) {
            res += 0 == target ? 1 : 0;
            return;
        }

        bt(nums, i + 1, target + nums[i]);
        bt(nums, i + 1, target - nums[i]);
    }

    public static void main(String[] args) {
        SolutionBT s = new SolutionBT();
        System.out.println(s.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
