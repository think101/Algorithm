package main.com.think101.leetcode.Patterns.BFS.CourseSchedule2;

import java.util.*;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = new HashMap<>(); // course -> prereqs
        Map<Integer, Set<Integer>> rGraph = new HashMap<>(); // course -> courses take course as prereqs

        for(int[] p : prerequisites){
            if(!graph.containsKey(p[0])) graph.put(p[0], new HashSet<>());
            if(!rGraph.containsKey(p[1])) rGraph.put(p[1], new HashSet<>());
            graph.get(p[0]).add(p[1]);
            rGraph.get(p[1]).add(p[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++)
            if(!graph.containsKey(i)) queue.add(i);

        List<Integer> res = new ArrayList<>();
        while(queue.size() > 0) {
            int cnt = queue.size();

            for(int i = 0; i < cnt; i++) {
                int prereq = queue.poll();

                if(rGraph.containsKey(prereq)) {
                    for(int c : rGraph.get(prereq)) {
                        graph.get(c).remove(prereq);

                        // no prereqs then put into queue
                        if(graph.get(c).size() == 0)
                            queue.add(c);
                    }
                }


                res.add(prereq);
            }
        }

        return res.size() == numCourses ? res.stream().mapToInt(i -> i).toArray() : new int[0];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.findOrder(2, new int[][]{{1,0}})));
        System.out.println(Arrays.toString(s.findOrder(4, new int[][]{{1,0},{2,0}, {3,1}, {3,2}})));
    }
}
