package main.com.think101.leetcode.MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        int length = intervals.length;
        List<int[]> res = new ArrayList<>();

        for(int i=0; i<length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            while(i+1<length && intervals[i+1][0] <= end) {                         // note 1
                end = Math.max(intervals[i + 1][1], end);            // note 2
                i++;
            }

            res.add(new int[]{start, end});
        }

        int[][] result = new int[res.size()][];
        for(int i=0; i<res.size(); i++){
            result[i] = res.get(i);
        }

        return result;
    }
}
