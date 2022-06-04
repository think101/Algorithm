package main.com.think101.leetcode.Grind75.BasicCalculator;

import java.util.Stack;

public class Solution {
    public int calculate(String s) {
        s = s.replaceAll("\\s+", "");

        Stack<String> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '-') {
                // - char bind with the char(s) after it
                if(stack.empty() || !Character.isDigit(stack.peek().charAt(0))) {
                    int end = getNumber(s, i+1);
                    stack.push(s.substring(i, end+1));
                    i = end;
                }
                else {
                    stack.push(s.substring(i, i+1));
                }
            }
            else if(s.charAt(i) == '+' || s.charAt(i) == '('){
                stack.push(s.substring(i, i+1));
            }
            else if(s.charAt(i) == ')') {
                String t = stack.pop();
                stack.pop();    // pop '('

                cleanStack(stack,  Integer.parseInt(t));
            }
            else {
                // a number
                int end = getNumber(s, i);
                int n = Integer.parseInt(s.substring(i, end+1));

                cleanStack(stack, n);

                i = end;
            }
        }

        return Integer.parseInt(stack.pop());
    }

    private void cleanStack(Stack<String> stack, int n) {
        while(!stack.empty() && (stack.peek().charAt(0) == '+' || stack.peek().charAt(0) == '-')) {
            String op = stack.pop();

            if(stack.empty()) {
                stack.push(op + n);
                return;
            }

            int prevNum = Integer.parseInt(stack.pop());

            if(op.equals("+")) {
                n = prevNum + n;
            }
            else{
                n = prevNum - n;
            }
        }

        stack.push(String.valueOf(n));
    }


    private int getNumber(String s, int start) {
        int end = start;
        while(end < s.length() && Character.isDigit(s.charAt(end))) {
            end++;
        }

        return end-1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        //System.out.println(s.calculate("(1+(4+5+2)-3)+(6+8)"));
        //System.out.println(s.calculate("-2+ 1"));
        //System.out.println(s.calculate("- (3 + (4 + 5))"));
        System.out.println(s.calculate("1-(3+5-2+(3+19-(3-1-4+(9-4-(4-(1+(3)-2)-5)+8-(3-5)-1)-4)-5)-4+3-9)-4-(3+2-5)-10"));
    }
}
