package main.com.think101.leetcode.Patterns.SegmentTree.MyCalendarII;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendarTwo {
    TreeMap<Integer, Integer> singleBooking;
    TreeMap<Integer, Integer> doubleBooking;

    public MyCalendarTwo() {
        singleBooking = new TreeMap<>();
        doubleBooking = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        if(singleBooking.size() == 0 && doubleBooking.size() == 0){
            singleBooking.put(start,end);
            return true;
        }

        Integer floorKey;
        Integer ceilingKey;
        // first check whether there is triple booking
        if(doubleBooking.size() > 0){
            floorKey = doubleBooking.floorKey(start);
            ceilingKey = doubleBooking.ceilingKey(start);

            if((floorKey == null && end > doubleBooking.firstKey()) ||
                    (ceilingKey == null && start < doubleBooking.get(doubleBooking.lastKey())) ||
                    (floorKey != null && start < doubleBooking.get(floorKey)) ||
                    (ceilingKey != null && end > ceilingKey)) {
                return false;
            }
        }

        // chech whether new double booking created
        floorKey = singleBooking.floorKey(start);
        ceilingKey = singleBooking.ceilingKey(start);

        // if no overlap with others
        if((floorKey == null && end <= singleBooking.firstKey()) ||
                (ceilingKey == null && start >= singleBooking.get(singleBooking.lastKey())) ||
                (floorKey != null && start >= singleBooking.get(floorKey)
                        && ceilingKey != null && end <= ceilingKey)) {
            singleBooking.put(start,end);
            return true;
        }
        else {
            for(Map.Entry<Integer, Integer> entry : singleBooking.entrySet()) {
                if( !(start >= entry.getValue() || end <= entry.getKey())) {
                    doubleBooking.put(Math.max(start, entry.getKey()), Math.min(end, entry.getValue()));
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
        System.out.println(myCalendarTwo.book(10, 20));
        System.out.println(myCalendarTwo.book(50, 60));
        System.out.println(myCalendarTwo.book(10, 40));
        System.out.println(myCalendarTwo.book(5, 15));
        System.out.println(myCalendarTwo.book(5, 10));
        System.out.println(myCalendarTwo.book(25, 55));
    }
}

