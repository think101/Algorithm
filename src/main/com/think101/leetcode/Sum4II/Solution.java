package main.com.think101.leetcode.Sum4II;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        int[][] allNums = new int[4][nums1.length];
        allNums[0] = nums1;
        allNums[1] = nums2;
        allNums[2] = nums3;
        allNums[3] = nums4;

        Map<Integer, Map<Integer, Integer>> numsCounts = new HashMap<>();
        for(int n=0; n<4; n++) {
            Map<Integer, Integer> numsCount = new HashMap<>();
            for(int i : allNums[n]) {
                if(!numsCount.containsKey(i))
                    numsCount.put(i, 0);

                numsCount.put(i, numsCount.get(i)+1);
            }

            numsCounts.put(n+1, numsCount);
        }

        Map<Integer, Integer> numsCount = new HashMap<>();
        for(int i : numsCounts.get(1).keySet()) {
            for(int j :numsCounts.get(2).keySet()) {
                if(!numsCount.containsKey(i+j))
                    numsCount.put(i+j, 0);

                numsCount.put(i+j, numsCount.get(i+j)+numsCounts.get(1).get(i) * numsCounts.get(2).get(j));
            }
        }
        numsCounts.put(12, numsCount);


        for(int i : numsCounts.get(12).keySet()) {
            for(int j : numsCounts.get(3).keySet()) {

                int t = -i - j;

                if(numsCounts.get(4).containsKey(t))
                    res += numsCounts.get(12).get(i) * numsCounts.get(3).get(j)
                            * numsCounts.get(4).get(t);

            }
        }

        return res;
    }

    public int fourSumCount_TLE(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        int[][] allNums = new int[4][nums1.length];
        allNums[0] = nums1;
        allNums[1] = nums2;
        allNums[2] = nums3;
        allNums[3] = nums4;

        Map<Integer, TreeMap<Integer, Integer>> numsCounts = new HashMap<>();
        for(int n=0; n<4; n++) {
            TreeMap<Integer, Integer> numsCount = new TreeMap<>();
            for(int i : allNums[n]) {
                if(!numsCount.containsKey(i))
                    numsCount.put(i, 0);

                numsCount.put(i, numsCount.get(i)+1);
            }

            numsCounts.put(n+1, numsCount);
        }

        for(int i : numsCounts.get(1).keySet()) {
            for(int j : numsCounts.get(2).keySet()) {
                for(int k : numsCounts.get(3).keySet()) {
                    if(i + j + k + numsCounts.get(4).firstKey() >0)
                        break;

                    int t = -i - j - k;

                    if(numsCounts.get(4).containsKey(t))
                        res += numsCounts.get(1).get(i) * numsCounts.get(2).get(j)
                                * numsCounts.get(3).get(k) * numsCounts.get(4).get(t);
                }
            }
        }

        return res;
    }
}
