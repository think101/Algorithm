package main.com.think101.leetcode.Patterns.ArraysHashing.BrickWall;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> edgeCnt = new HashMap<>();

        for(List<Integer> row : wall) {
            int curr = 0;
            for(int i = 0; i < row.size() - 1; i++) {
                curr = curr + row.get(i);

                if(!edgeCnt.containsKey(curr)) edgeCnt.put(curr, 0);

                edgeCnt.put(curr, edgeCnt.get(curr) + 1);
            }
        }

        // edge cross most edges
        int res = 0;
        for(int k : edgeCnt.keySet()) res = Math.max(res, edgeCnt.get(k));

        return wall.size() - res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> wall = List.of(List.of(1, 2, 2, 1), List.of(3, 1, 2), List.of(1, 3, 2), List.of(2, 4), List.of(3, 1, 2), List.of(1, 3, 1, 1));
        System.out.println(s.leastBricks(wall));
    }
}
