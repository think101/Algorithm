package main.com.think101.leetcode.Patterns.SegmentTree.MyCalendarII;

import java.util.TreeMap;

public class MyCalendarTwo {
    TreeMap<Integer, Integer> singleBooking;
    TreeMap<Integer, Integer> doubleBooking;

    public MyCalendarTwo() {
        singleBooking = new TreeMap<>();
        doubleBooking = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        if(singleBooking.size() == 0 || doubleBooking.size() == 0){
            singleBooking.put(start,end);
            return true;
        }

        // first check whether there is triple booking
        Integer floorKey = doubleBooking.floorKey(start);
        Integer ceilingKey = doubleBooking.ceilingKey(start);

        if((floorKey == null && end > doubleBooking.firstKey()) ||
                (ceilingKey == null && start < doubleBooking.get(doubleBooking.lastKey())) ||
                start < doubleBooking.get(floorKey) || end > ceilingKey) {
            return false;
        }

        // chech whether new double booking created
        floorKey = singleBooking.floorKey(start);
        ceilingKey = singleBooking.ceilingKey(start);

        // if no overlap with others
        if((floorKey == null && end <= singleBooking.firstKey()) ||
                (ceilingKey == null && start >= singleBooking.get(singleBooking.lastKey())) ||
                (start >= singleBooking.get(floorKey) && end <= ceilingKey)) {
            singleBooking.put(start,end);
            return true;
        }
        else {

        }

        return false;

    }
}

