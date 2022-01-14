package main.com.think101.leetcode.UglyNumber2;

public class Solution {

    public int nthUglyNumber(int n) {
        int[] result = new int[n];
        result[0] = 1;

        int i2 = 0, i3 = 0, i5 = 0;
        for(int i=1; i<n; i++) {
            int t = Math.min(Math.min(result[i2] * 2, result[i3] * 3), result[i5] * 5);

            if(result[i2] * 2 == t)
                i2++;
            if(result[i3] * 3 == t)
                i3++;
            if(result[i5] * 5 == t)
                i5++;

            result[i] = t;
        }

        return result[n-1];
    }
}
