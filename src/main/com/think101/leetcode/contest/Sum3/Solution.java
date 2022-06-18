package main.com.think101.leetcode.contest.Sum3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            if (!count.containsKey(num)) {
                count.put(num, 0);
            }

            count.put(num, count.get(num) + 1);
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(i - 1 >= 0 && nums[i - 1] == nums[i])
                continue;

            for(int j = i+1; j < nums.length; j++) {
                if(j - 1 >= 0 && j - 1 != i && nums[j - 1] == nums[j])
                    continue;

                int t = - nums[i] - nums[j];
                if( t < nums[j])
                    continue;

                if(count.containsKey(t) && count.get(t) >= (1
                        + (nums[i] == t ? 1 : 0) + (nums[j] == t ? 1 : 0))) {
                    result.add(Arrays.asList(nums[i], nums[j], t));
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));

        System.out.println(solution.threeSum(new int[]{0, 0, 0}));
        System.out.println(solution.threeSum(new int[]{0, 0, 0, 0}));
    }
}
