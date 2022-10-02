package main.com.think101.leetcode.Patterns.BFS.CourseSchedule2;

import java.util.*;

public class Solution2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> prereqs = new HashMap<>();
        Map<Integer, Set<Integer>> asPrereqs = new HashMap<>();
        Queue<Integer> finish = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        for(int[] p : prerequisites) {
            if(!prereqs.containsKey(p[0]))
                prereqs.put(p[0], new HashSet<>());
            if(!asPrereqs.containsKey(p[1]))
                asPrereqs.put(p[1], new HashSet<>());

            prereqs.get(p[0]).add(p[1]);
            asPrereqs.get(p[1]).add(p[0]);
        }

        for(int i = 0; i < numCourses; i++)
            if(!prereqs.containsKey(i))
                finish.add(i);

        while(finish.size() > 0) {
            int len = finish.size();

            for(int i = 0; i < len; i++) {
                int c = finish.poll();

                res.add(c);

                if(asPrereqs.containsKey(c)) {
                    for(int asP : asPrereqs.get(c)){
                        prereqs.get(asP).remove(c);
                        if(prereqs.get(asP).size() == 0) {
                            finish.add(asP);
                            prereqs.remove(asP);
                        }
                    }
                }
            }
        }

        if(prereqs.size() > 0) return new int[0];

        return res.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(Arrays.toString(s.findOrder(2, new int[][]{{1,0}})));
        System.out.println(Arrays.toString(s.findOrder(4, new int[][]{{1,0},{2,0}, {3,1}, {3,2}})));
    }
}
