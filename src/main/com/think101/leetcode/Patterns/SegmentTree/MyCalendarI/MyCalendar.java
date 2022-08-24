package main.com.think101.leetcode.Patterns.SegmentTree.MyCalendarI;

import java.util.TreeMap;

public class MyCalendar {
    TreeMap<Integer, Integer> cals;

    public MyCalendar() {
        cals = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer floorKey = cals.floorKey(start);
        Integer ceilingKey = cals.ceilingKey(start);

        if(cals.size() == 0){
            cals.put(start, end);
            return true;
        }

        boolean res;
        if(floorKey == null) {
            res = end <= cals.firstKey();
        }
        else if(floorKey.equals(cals.lastKey())){
            res = start >= cals.get(cals.lastKey());
        }
        else {
            res = start >= cals.get(floorKey) && end <= ceilingKey;
        }

        if(res) {
            cals.put(start, end);
        }

        return res;
    }

    public static void main(String[] args) {
        MyCalendar obj = new MyCalendar();
        System.out.println(obj.book(47, 50));
        System.out.println(obj.book(33, 41));
        System.out.println(obj.book(39, 45));
    }
}
