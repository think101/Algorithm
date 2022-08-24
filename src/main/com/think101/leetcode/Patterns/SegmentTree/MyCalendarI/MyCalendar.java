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

        if(floorKey == null) {
            return end <= cals.firstKey();
        }
        else if(floorKey.equals(cals.lastKey())){
            return start >= cals.get(cals.lastKey());
        }
        else {
            return start >= cals.get(floorKey) && end <= ceilingKey;
        }
    }

    public static void main(String[] args) {
        MyCalendar obj = new MyCalendar();
        System.out.println(obj.book(10, 20));
        System.out.println(obj.book(15, 25));
        System.out.println(obj.book(20, 30));
    }
}
