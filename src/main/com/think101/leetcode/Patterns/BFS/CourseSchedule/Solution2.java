package main.com.think101.leetcode.Patterns.BFS.CourseSchedule;

import java.util.*;

public class Solution2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> prereqs = new HashMap<>();   // course to its prereqs
        Map<Integer, Set<Integer>> asPrereqs = new HashMap<>();   // course dependented by other courses

        Queue<Integer> finish = new LinkedList<>();

        for(int[] prereq : prerequisites) {
            if(!prereqs.containsKey(prereq[0])) {
                prereqs.put(prereq[0], new HashSet<>());
            }
            prereqs.get(prereq[0]).add(prereq[1]);

            if(!asPrereqs.containsKey(prereq[1])) {
                asPrereqs.put(prereq[1], new HashSet<>());
            }
            asPrereqs.get(prereq[1]).add(prereq[0]);
        }

        for(int i = 0; i < numCourses; i++) {
            if(!prereqs.containsKey(i))
                finish.add(i);
        }

        while(finish.size() > 0) {
            int c = finish.poll();

            if(asPrereqs.containsKey(c)) {
                for(int asP : asPrereqs.get(c)) {
                    prereqs.get(asP).remove(c);
                    if(prereqs.get(asP).size() == 0){
                        finish.add(asP);
                        prereqs.remove(asP);
                    }
                }
            }
        }
        return prereqs.size() == 0;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.canFinish(2, new int[][]{{1,0}}));
        System.out.println(s.canFinish(2, new int[][]{{1,0},{0,1}}));
        System.out.println(s.canFinish(2, new int[][]{{1,0},{0,1},{0,1}}));
    }
}
