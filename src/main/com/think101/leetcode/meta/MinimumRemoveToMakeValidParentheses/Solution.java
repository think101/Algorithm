package main.com.think101.leetcode.meta.MinimumRemoveToMakeValidParentheses;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> removePos = new HashSet<>();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') stack.push(i);
            else if(s.charAt(i) == ')') {
                if(stack.size() > 0) {
                    stack.pop();
                }
                else {
                    removePos.add(i);
                }
            }
        }

        while(stack.size() > 0) {
            removePos.add(stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(!removePos.contains(i)) sb.append(s.charAt(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(s.minRemoveToMakeValid("a)b(c)d"));
        System.out.println(s.minRemoveToMakeValid("))(("));
        System.out.println(s.minRemoveToMakeValid("(a(b(c)d)"));
        System.out.println(s.minRemoveToMakeValid("a(b(c)d)"));
    }
}