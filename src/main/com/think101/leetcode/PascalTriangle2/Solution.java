package main.com.think101.leetcode.PascalTriangle2;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        result.add(l1);

        if(rowIndex == 0) return result.get(0);

        List<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(1);
        result.add(l2);

        if(rowIndex == 1) return result.get(1);

        for(int i=2; i<= rowIndex; i++) {
            List<Integer> l = result.get(i-1);
            List<Integer> t = new ArrayList<>();
            t.add(1);
            for(int j=0; j<l.size()-1; j++){
                t.add(l.get(j) + l.get(j+1));
            }
            t.add(1);

            result.add(t);
        }

        return result.get(rowIndex);
    }
}
