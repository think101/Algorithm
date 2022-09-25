package main.com.think101.leetcode.Patterns.Greedy.ValidParenthesisString;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean checkValidString(String s) {
        Queue<Character> queue = new LinkedList<>();

        int i = 0;
        while( i < s.length() ) {
            char c = s.charAt(i);

            if(c == '(') {
                queue.add(c);
            }
            else if (c == ')') {
                if(queue.size() == 0) return false;

                queue.poll();
            }
            else {
                // process * char

                // queue's size and ')' char count should be within 1
                int j = i+1;
                while(j < s.length() && s.charAt(j) == ')'){
                    j++;
                }

                if(j - 1 - i > 0) {
                    int pollCnt = Math.min(queue.size(), j - 1 - i);
                    for(int k = 0; k < pollCnt; k++)
                        queue.poll();

                    i = j;
                }
                else {
                    queue.add('(');
                }
            }

            i++;
        }

        return queue.size() == 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.checkValidString("()"));
        System.out.println(s.checkValidString("(*)"));
        System.out.println(s.checkValidString("(*))"));
    }
}
