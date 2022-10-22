package main.com.think101.leetcode.Patterns.Stack.CarFleet;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Integer> posToInd = new TreeMap<>();
        for(int i = 0; i < position.length; i++)
            posToInd.put(position[i], i);

        Stack<Integer> s = new Stack<>();
        for(Map.Entry<Integer, Integer> entry : posToInd.entrySet()) {
            s.push(entry.getValue());
        }

        int res = 0;
        while(s.size() > 0) {
            res++;
            int i = s.pop();
            double time = (double)(target - position[i]) / speed[i];
            while(s.size() > 0) {
                double peekTime = (double)(target - position[s.peek()]) / speed[s.peek()];
                if(peekTime <= time) {
                    s.pop();
                }
                else {
                    break;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.carFleet(10, new int[]{6, 8}, new int[]{3, 2}));
    }
}
