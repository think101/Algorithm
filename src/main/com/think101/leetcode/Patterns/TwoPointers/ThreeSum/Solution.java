package main.com.think101.leetcode.Patterns.TwoPointers.ThreeSum;

import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        Map<Integer, Integer> numCnt = new HashMap<>();
        for (int num : nums) {
            if (!numCnt.containsKey(num))
                numCnt.put(num, 0);

            numCnt.put(num, numCnt.get(num) + 1);
        }


        for(int i = 0; i < len; i++){
            if(i - 1 >= 0 && nums[i] == nums[i-1]) continue;

            for(int j = i+1; j < len; j++){
                if(j - 1 >= i+1 && nums[j] == nums[j-1]) continue;

                if(nums[i] + nums[j] > 0) break;

                int t = - nums[i] - nums[j];
                if(t < nums[j]) continue;

                if(numCnt.containsKey(t) &&
                        numCnt.get(t) >= 1 + (nums[i] == t ? 1 : 0) + (nums[j] == t ? 1 : 0)) {
                    List<Integer> l = Arrays.asList(nums[i], nums[j], t);
                    res.add(l);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(s.threeSum(new int[]{}));
        System.out.println(s.threeSum(new int[]{0, 0, 0}));
    }
}
