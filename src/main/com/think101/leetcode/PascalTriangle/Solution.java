package main.com.think101.leetcode.PascalTriangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        result.add(l1);

        if(numRows == 1) return result;

        List<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(1);
        result.add(l2);

        if(numRows == 2) return result;

        for(int i=3; i<= numRows; i++) {
            List<Integer> l = result.get(i-2);
            List<Integer> t = new ArrayList<>();
            t.add(1);
            for(int j=0; j<l.size()-1; j++){
                t.add(l.get(j) + l.get(j+1));
            }
            t.add(1);

            result.add(t);
        }

        return result;
    }
}
