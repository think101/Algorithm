package main.com.think101.leetcode.Patterns.ArraysHashing.GroupAnagrams;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();

        for(String s : strs) {
            int[] a = new int[26];

            for(int i = 0; i < s.length(); i++)
                a[s.charAt(i) - 'a']++;

            //String as = new String(a);  // wrong
            String as = Arrays.toString(a);
            if(!res.containsKey(as))
                res.put(as, new ArrayList<>());

            res.get(as).add(s);
        }

        return new ArrayList<>(res.values());
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
