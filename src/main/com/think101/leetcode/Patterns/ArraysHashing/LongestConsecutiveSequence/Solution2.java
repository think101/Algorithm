package main.com.think101.leetcode.Patterns.ArraysHashing.LongestConsecutiveSequence;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class Solution2 {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;

        Set<Integer> numsSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int res = 1;
        int curr = 1;

        for(int i = 0; i < nums.length; i++){
            if(numsSet.isEmpty()) return res;

            if(numsSet.contains(nums[i])) {
                numsSet.remove(nums[i]);
                curr = 1;

                int t = nums[i];
                while(numsSet.contains(t - 1)){
                    curr++;
                    numsSet.remove(t - 1);
                    t--;
                }

                t = nums[i];
                while(numsSet.contains(t + 1)){
                    curr++;
                    numsSet.remove(t + 1);
                    t++;
                }

                res = Math.max(res, curr);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(s.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }
}
