package main.com.think101.leetcode.Patterns.ArraysHashing.NonDecreasingArray;

import java.util.NavigableMap;
import java.util.TreeMap;

public class Solution {
    public boolean checkPossibility(int[] nums) {
        TreeMap<Integer, Integer> checked = new TreeMap<>();

        for(int i = 0; i < nums.length; i++) {
            NavigableMap<Integer, Integer> tMap = checked.tailMap(nums[i], false);
            if(tMap.size() > 1 || (tMap.size() == 1 && tMap.firstEntry().getValue() > 1)) return false;

            if(!checked.containsKey(nums[i])) {
                checked.put(nums[i], 0);
            }

            checked.put(nums[i], checked.get(nums[i]) + 1);
        }

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.checkPossibility(new int[]{4, 2, 3}));
        System.out.println(s.checkPossibility(new int[]{4, 2, 1}));
        System.out.println(s.checkPossibility(new int[]{3, 4, 2, 3}));
    }
}
