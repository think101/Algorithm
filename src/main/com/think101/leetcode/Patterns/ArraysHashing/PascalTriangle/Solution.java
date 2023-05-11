package main.com.think101.leetcode.Patterns.ArraysHashing.PascalTriangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(List.of(1));

        if(numRows == 1) return res;

        for(int j = 2; j <= numRows; j++) {
            List<Integer> prev = res.get(res.size() - 1);
            List<Integer> curr = new ArrayList<>();

            for(int i = 0; i <= prev.size(); i++) {
                int left = i - 1 >= 0 ? prev.get(i - 1) : 0;
                int right = i < prev.size() ? prev.get(i) : 0;

                curr.add(left + right);
            }

            res.add(curr);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.generate(5));
    }
}
