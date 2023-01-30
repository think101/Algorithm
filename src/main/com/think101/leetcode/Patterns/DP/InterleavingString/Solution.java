package main.com.think101.leetcode.Patterns.DP.InterleavingString;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    Map<List<Integer>, Boolean> dp = new HashMap<>();

    public boolean isInterleave(String s1, String s2, String s3) {
        return helper(s1, s2, s3, 0, 0);
    }

    private boolean helper(String s1, String s2, String s3, int i1, int i2) {
        if(dp.containsKey(Arrays.asList(i1, i2))) return dp.get(Arrays.asList(i1, i2));

        boolean b;
        if(i1 >= s1.length() || i2 >= s2.length()) {
            b = (i2 >= s2.length() && s1.substring(i1).equals(s3.substring(i1 + i2))) ||
                    (i1 >= s1.length() && s2.substring(i2).equals(s3.substring(i1 + i2)));
            dp.put(Arrays.asList(i1, i2), b);
            return b;
        }

        if(i1 + i2 >= s3.length()) return false;

        char t = s3.charAt(i1 + i2);
        if(s1.charAt(i1) != t && s2.charAt(i2) != t) b = false;
        else if(s1.charAt(i1) == t && s2.charAt(i2) == t) {
            b = helper(s1, s2, s3, i1 + 1, i2) || helper(s1, s2, s3, i1, i2 + 1);
        }
        else if(s1.charAt(i1) == t) b = helper(s1, s2, s3, i1 + 1, i2);
        else b = helper(s1, s2, s3, i1, i2 + 1);

        dp.put(Arrays.asList(i1, i2), b);
        return b;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isInterleave("a", "b", "a"));
    }
}
