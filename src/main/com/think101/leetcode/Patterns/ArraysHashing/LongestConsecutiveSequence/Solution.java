package main.com.think101.leetcode.Patterns.ArraysHashing.LongestConsecutiveSequence;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    int res = 0;

    public int longestConsecutive(int[] nums) {
        Set<Integer> s = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        Set<Integer> used = new HashSet<>();

        for (int num : nums) {
            if (used.contains(num)) continue;

            used.add(num);

            int t = num;
            int cnt = 1;
            while (s.contains(--t)) {
                used.add(t);
                cnt++;
            }

            t = num;
            while (s.contains(++t)) {
                used.add(t);
                cnt++;
            }

            res = Math.max(res, cnt);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(s.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }
}
