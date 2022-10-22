package main.com.think101.leetcode.Patterns.Stack.MinStack;

import java.util.Stack;

public class Solution {
    Stack<Integer> s;
    Stack<Integer> minS;

    public Solution() {
        s = new Stack<>();
        minS = new Stack<>();
    }

    public void push(int val) {
        s.push(val);
        int min = s.size() > 1 ? Math.min(minS.peek(), val) : val;
        minS.push(min);
    }

    public void pop() {
        s.pop();
        minS.pop();
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return minS.peek();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.push(-2);
        s.push(0);
        s.push(-3);
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.top());
        System.out.println(s.getMin());
    }
}