package main.com.think101.leetcode.FindTheDuplicateNumber;

import java.util.BitSet;

public class Solution {
    public int findDuplicate(int[] nums) {
        BitSet bs = new BitSet(100001);

        for (int num : nums) {
            if (bs.get(num))
                return num;

            bs.set(num);
        }

        return -1;
    }

    // case [2,2,2,2,2]
    // case [1,4,4,2,4]
    public int findDuplicate_Wrong(int[] nums) {
        int expectSum = 0;
        int actualSum = 0;
        boolean allSame = true;
        for(int i=0; i<nums.length-1; i++) {
            expectSum += i+1;
            actualSum += nums[i];
            if(nums[i+1] != nums[i])
                allSame = false;
        }

        return allSame ? nums[0] : actualSum + nums[nums.length-1] - expectSum;
    }
}
