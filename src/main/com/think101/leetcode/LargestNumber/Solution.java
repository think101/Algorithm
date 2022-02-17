package main.com.think101.leetcode.LargestNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public String largestNumber(int[] nums) {

        List<String> ls = new ArrayList<>();
        for(int i : nums)
            ls.add(String.valueOf(i));

        Comparator<String> cp = (s1, s2) -> {
            String t1 = s1 + s2;
            String t2 = s2 + s1;
            return t2.compareTo(t1);
        };

        ls.sort(cp);

        if(ls.get(0).charAt(0) == '0')
            return "0";

        StringBuilder sb = new StringBuilder();
        for(String s : ls)
            sb.append(s);

        return sb.toString();
    }
}
