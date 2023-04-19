package main.com.think101.leetcode.Patterns.ArraysHashing.SubarraySumEqualsK;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, List<Integer>> sumIndex = new HashMap<>();
        int sum = 0, res = 0;

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if(sum == k ) res++;
            if(sumIndex.containsKey(sum - k)) {
                res += sumIndex.get(sum - k).size();
            }
            if(!sumIndex.containsKey(sum)) sumIndex.put(sum, new ArrayList<>());

            sumIndex.get(sum).add(i);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 2, 1, 2, 1};
        System.out.println(s.subarraySum(nums, 3));
    }
}
