package main.com.think101.leetcode.Patterns.Greedy.ValidParenthesisString;

public class Solution {
    public boolean checkValidString(String s) {
        int openMin = 0, openMax = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '('){
                openMin++;
                openMax++;
            }
            else if(c == ')'){
                openMin--;
                openMax--;

                if(openMax < 0) return false;
                if(openMin < 0) openMin = 0;
            }
            else {
                openMin--;
                openMax++;

                if(openMin < 0) openMin = 0;
            }
        }

        return openMin <= 0 && 0 <= openMax;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.checkValidString("()"));
        System.out.println(s.checkValidString("(*)"));
        System.out.println(s.checkValidString("(*))"));
    }
}
