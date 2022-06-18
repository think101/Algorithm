package main.com.think101.leetcode.contest.Sum3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        HashMap<Integer, Integer> count = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!count.containsKey(nums[i])){
                count.put(nums[i], 0)
            }

            count.put(nums[i], count.get(nums[i]) + 1);
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(i - 1 >= 0 && nums[i - 1] == nums[i])
                continue;

            for(int j = 0; j < nums.length; j++) {
                int t = - nums[i] - nums[j];
                if(count.containsKey(t) && count.get(t) >= 1
                        + nums[i] == t ? 1 : 0 + nums[j] == t ? 1 : 0) {
                    result.add(new ArrayList<Integer>{nums[i], nums[j], t});
                }
            }
        }

        return result;
    }
}
