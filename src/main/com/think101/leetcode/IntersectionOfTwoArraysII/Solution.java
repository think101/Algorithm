package main.com.think101.leetcode.IntersectionOfTwoArraysII;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] freq = new int[1001];

        for(int i : nums1)
            freq[i]++;

        List<Integer> res = new ArrayList<>();
        for(int i : nums2) {
            if(freq[i] > 0) {
                freq[i]--;
                res.add(i);
            }
        }

        return res.stream().mapToInt(i->i).toArray();
    }
}
