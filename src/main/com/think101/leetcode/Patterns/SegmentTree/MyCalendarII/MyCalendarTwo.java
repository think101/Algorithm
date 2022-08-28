package main.com.think101.leetcode.Patterns.SegmentTree.MyCalendarII;

import java.util.ArrayList;
import java.util.List;
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
            List<int[]> addToSingle = new ArrayList<>();
            int t1 = -1;
            int t2 = -1;
            for(Map.Entry<Integer, Integer> entry : singleBooking.entrySet()) {
                if( !(start >= entry.getValue() || end <= entry.getKey())) {
                    t1 = Math.max(start, entry.getKey());
                    t2 = Math.min(end, entry.getValue());
                    doubleBooking.put(t1, t2);

                    if(start != t1) {
                        addToSingle.add(new int[]{start, t1});
                        start = t2;
                    }
                }
            }

            for(int[] a : addToSingle) {
                singleBooking.put(a[0], a[1]);
            }

            if(end > t2) {
                singleBooking.put(t2, end);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
        System.out.println(myCalendarTwo.book(47, 50));
        System.out.println(myCalendarTwo.book(1, 10));
        System.out.println(myCalendarTwo.book(27, 36));
        System.out.println(myCalendarTwo.book(40, 47));
        System.out.println(myCalendarTwo.book(20, 27));
        System.out.println(myCalendarTwo.book(15, 23));
        System.out.println(myCalendarTwo.book(10, 18));
        System.out.println(myCalendarTwo.book(27, 36));
        System.out.println(myCalendarTwo.book(17, 25));
        System.out.println(myCalendarTwo.book(8, 17));
    }
}

