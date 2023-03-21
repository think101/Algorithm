package main.com.think101.leetcode.Patterns.BFS.CourseSchedule2;

import java.util.*;

public class Solution3 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Set<Integer>> prereqs = new HashMap<>();
        Map<Integer, Set<Integer>> revPS = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();

        for(int[] p : prerequisites) {
            if(!prereqs.containsKey(p[0])) {
                prereqs.put(p[0], new HashSet<>());
            }
            if(!revPS.containsKey(p[1])) {
                revPS.put(p[1], new HashSet<>());
            }

            prereqs.get(p[0]).add(p[1]);
            revPS.get(p[1]).add(p[0]);
        }

        for(int i = 0; i < numCourses; i++) {
            if(!prereqs.containsKey(i))
                queue.add(i);
        }

        while(queue.size() > 0) {
            int c = queue.poll();
            res.add(c);
            if(revPS.containsKey(c)) {
                for(int cDep : revPS.get(c)) {
                    prereqs.get(cDep).remove(c);
                    if(prereqs.get(cDep).size() == 0) {
                        queue.add(cDep);
                        prereqs.remove(cDep);
                    }
                }
            }
        }

        return prereqs.size() == 0 ? res.stream().mapToInt(i -> i).toArray() : new int[]{};
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        System.out.println(Arrays.toString(s.findOrder(2, new int[][]{{1,0}})));
        System.out.println(Arrays.toString(s.findOrder(2, new int[][]{{1,0},{0,1}})));
        System.out.println(Arrays.toString(s.findOrder(2, new int[][]{{1,0},{0,1},{0,1}})));
    }
}
