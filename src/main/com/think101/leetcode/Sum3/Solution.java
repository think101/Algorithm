package main.com.think101.leetcode.Sum3;

import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        Map<Integer, Integer> numsCount = new HashMap<>();
        for(int i : nums) {
            if(!numsCount.containsKey(i))
                numsCount.put(i, 0);

            numsCount.put(i, numsCount.get(i)+1);
        }

        for(int i=0; i<nums.length; i++) {
            if(i-1>=0 && nums[i] == nums[i-1])
                continue;

            for(int j=i+1; j<nums.length; j++) {
                if(j-1 != i && nums[j] == nums[j-1])
                    continue;

                int t = -nums[i] - nums[j];
                if(t >= nums[j] && numsCount.containsKey(t) &&
                        numsCount.get(t) >= 1 + (nums[i]==t ? 1 : 0) + (nums[j]==t ? 1 : 0)) {
                    List<Integer> l = Arrays.asList(nums[i], nums[j], t);
                    result.add(l);
                }
            }
        }

        return result;
    }

    public List<List<Integer>> threeSum_2Pointers(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++) {
            if(i-1>=0 && nums[i] == nums[i-1])
                continue;

            int j=i+1, k= nums.length-1;

            while(j<k) {
                if(j-1 != i && nums[j] ==nums[j-1]) {
                    j++;
                    continue;
                }

                if(nums[j]+nums[k] > -nums[i]) k--;
                else if(nums[j]+nums[k] < -nums[i]) j++;
                else {
                    List<Integer> l = Arrays.asList(nums[i], nums[j], nums[k]);
                    result.add(l);

                    j++;
                    k--;
                }
            }
        }


        return result;
    }
}
