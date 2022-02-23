package main.com.think101.leetcode.PowerofThree;

public class Solution {
    public boolean isPowerOfThree(int n) {
        if(n == 3 || n == 1) return true;
        else if(n < 3) return false;

        if(n%3 != 0) return false;
        return isPowerOfThree(n/3);
    }
}
