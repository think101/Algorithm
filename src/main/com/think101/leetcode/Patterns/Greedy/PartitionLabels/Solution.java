package main.com.think101.leetcode.Patterns.Greedy.PartitionLabels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastPos = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for(int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if(!lastPos.containsKey(c)) {
                lastPos.put(c, i);
            }
        }

        int i = 0, startPos = 0, endPos = 0;
        while( i < s.length()) {
            endPos = Math.max(endPos, lastPos.get(s.charAt(i)));

            // find a partition
            if(i == endPos) {
                res.add(endPos - startPos + 1);
                startPos = endPos + 1;
            }

            i++;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.partitionLabels("ababcbacadefegdehijhklij"));
    }
}
