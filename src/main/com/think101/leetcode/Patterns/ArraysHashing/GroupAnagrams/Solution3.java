package main.com.think101.leetcode.Patterns.ArraysHashing.GroupAnagrams;

import java.util.*;

class Solution3 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<>();

        for(String str : strs) {
            String sortedStr = sortStr(str);

            if(!m.containsKey(sortedStr)) {
                m.put(sortedStr, new ArrayList<String>());
            }

            m.get(sortedStr).add(str);
        }

        return new ArrayList<>(m.values());
    }

    private String sortStr(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        System.out.println(s.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
