package main.com.think101.leetcode.ArithmeticSlices;

public class Solutions {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length <= 2) return 0;

        int res = 0;
        int[] dp = new int[nums.length];
        dp[0] = dp[1] = 0;

        for(int i=2; i<nums.length; i++) {
            if(nums[i]-nums[i-1] == nums[i-1]-nums[i-2]) {
                dp[i] = dp[i-1]+1;
                res += dp[i];
            }
        }

        return res;
    }
}
