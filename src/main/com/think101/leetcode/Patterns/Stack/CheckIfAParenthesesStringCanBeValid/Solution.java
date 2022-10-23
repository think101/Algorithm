package main.com.think101.leetcode.Patterns.Stack.CheckIfAParenthesesStringCanBeValid;

import java.util.Stack;

public class Solution {
    public boolean canBeValid(String s, String locked) {
        int len = s.length();
        int unlockCnt = 0;
        Stack<Character> lockChars = new Stack<>();

        for(int i = 0; i < len; i++) {
            if(locked.charAt(i) == '1'){
                if(s.charAt(i) == ')') {
                    if((lockChars.size() == 0 || lockChars.peek() != '(') && unlockCnt == 0) return false;
                    else if(lockChars.size() > 0 && lockChars.peek() == '(') lockChars.pop();
                    else if(unlockCnt > 0) unlockCnt--;
                }
                else {
                    lockChars.push(s.charAt(i));
                }
            }
            else {
                if(lockChars.size() > 0) lockChars.pop();
                else unlockCnt++;
            }
        }

        return unlockCnt % 2 == 0 && lockChars.size() == 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.canBeValid("((()(()())", "1011110010"));
    }
}