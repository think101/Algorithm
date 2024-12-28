package main.com.think101.leetcode.BestSightseeingPair;

import java.util.Arrays;

public class WrongSolution {
    public int maxScoreSightseeingPair(int[] values) {
        int l = 0, r = values.length - 1;
        int res = values[l] + values[r] + l - r;

        if(l == r - 1) {
            return res;
        }

        while (l < r) {
            if(l == r - 1) {
                return res;
            }

            if(values[l] > values[r]) {
                r--;
            }
            else if(values[l] < values[r]) {
                l++;
            }
            else {
                if(l < r - 1) {
                    return Math.max(res, Math.max(maxScoreSightseeingPair(Arrays.copyOfRange(values, l + 1, r + 1)),
                            maxScoreSightseeingPair(Arrays.copyOfRange(values, l, r))));
                }
            }

            if(l != r) {
                res = Math.max(res, values[l] + values[r] + l - r);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        WrongSolution s = new WrongSolution();
        System.out.println(s.maxScoreSightseeingPair(new int[]{1, 2, 2}));
    }
}
