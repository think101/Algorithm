package main.com.think101.leetcode.Patterns.Stack.CheckIfAParenthesesStringCanBeValid;

public class Solution {
    public boolean canBeValid(String s, String locked) {
        return s.length() % 2 == 0 && valid(s, locked, '(') && valid(s, locked, ')');
    }

    private boolean valid(String s, String locked, char c) {
        int balance = 0, unlocked = 0;
        int start = c == '(' ? 0 : s.length() - 1;
        int inc = c == '(' ? 1 : -1;

        for(int i = start; i < s.length() && i >= 0 && balance + unlocked >= 0; i += inc) {
            char t = s.charAt(i);
            if(locked.charAt(i) != '1') unlocked++;
            else if(t == c) balance++;
            else balance--;
        }

        return Math.abs(balance) <= unlocked;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.canBeValid("((()(()())", "1011110010"));
    }
}