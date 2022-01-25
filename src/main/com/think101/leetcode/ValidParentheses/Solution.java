package main.com.think101.leetcode.ValidParentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    public boolean isValid(String s) {
        Map<Character, Character> t = new HashMap<>();
        t.put('}', '{');
        t.put(']', '[');
        t.put(')', '(');

        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            if(!t.containsKey(c)) {
                stack.push(c);
            }
            else {
                if(stack.isEmpty() || stack.pop() != t.get(c))
                    return false;
            }
        }

        return stack.isEmpty();
    }
}
