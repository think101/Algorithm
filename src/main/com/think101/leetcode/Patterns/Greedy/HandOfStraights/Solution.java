package main.com.think101.leetcode.Patterns.Greedy.HandOfStraights;

import java.util.TreeMap;

public class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;

        TreeMap<Integer, Integer> numCnt = new TreeMap<>();
        for(int i = 0; i < hand.length; i++) {
            if(!numCnt.containsKey(hand[i]))
                numCnt.put(hand[i], 0);

            numCnt.put(hand[i], numCnt.get(hand[i]) + 1);
        }

        while(numCnt.size() > 0) {
            int k = numCnt.firstKey();

            for(int j = 0; j < groupSize; j++) {
                if(!numCnt.containsKey(j + k)) return false;

                int t = numCnt.get(j + k) - 1;
                if(t == 0) numCnt.remove(j + k);
                else numCnt.put(j + k, t);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] hand = {1,2,3,6,2,3,4,7,8};
        int groupSize = 3;
        System.out.println(solution.isNStraightHand(hand, groupSize));
    }
}