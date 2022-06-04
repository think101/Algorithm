package main.com.think101.leetcode.Grind75.MaximumProfitInJobScheduling;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int len = startTime.length;
        int[][] jobs = new int[len][3];

        for(int i = 0; i < len; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[1]));

        TreeMap<Integer, Integer> dp = new TreeMap<>();
        dp.put(0, 0);

        for(int i = 0; i < len; i++ ) {
            int t = dp.floorEntry(jobs[i][0]).getValue() + jobs[i][2];
            if( t > dp.lastEntry().getValue()) {
                dp.put(jobs[i][1], t);
            }
        }

        return dp.lastEntry().getValue();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] startTime = new int[]{1, 2, 3, 3};
        int[] endTime = new int[]{3, 3, 4, 5};
        int[] profit = new int[]{50, 10, 40, 70};
        System.out.println(s.jobScheduling(startTime, endTime, profit));
    }
}
