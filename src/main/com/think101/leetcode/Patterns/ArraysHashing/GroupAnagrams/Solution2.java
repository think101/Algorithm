package main.com.think101.leetcode.Patterns.ArraysHashing.GroupAnagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> sortedToOrigins = new HashMap<>();

        for(String s :strs) {
            String sortedS = sortStr(s);
            if(!sortedToOrigins.containsKey(sortedS)) sortedToOrigins.put(sortedS, new ArrayList<>());

            sortedToOrigins.get(sortedS).add(s);
        }

        return new ArrayList<>(sortedToOrigins.values());
    }

    private String sortStr(String s) {
        return s.chars().sorted().mapToObj(String::valueOf).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
