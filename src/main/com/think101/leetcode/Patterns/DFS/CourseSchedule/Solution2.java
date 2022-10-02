package main.com.think101.leetcode.Patterns.DFS.CourseSchedule;

import java.util.*;

public class Solution2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> prereqs = new HashMap<>();
        for(int[] prereq : prerequisites) {
            if(!prereqs.containsKey(prereq[0]))
                prereqs.put(prereq[0], new HashSet<>());

            prereqs.get(prereq[0]).add(prereq[1]);
        }

        for(int i = 0; i < numCourses; i++) {
            if(!dfs(i, new ArrayList<>(), prereqs)) return false;
        }

        return true;
    }

    private boolean dfs(int c, List<Integer> visited, Map<Integer, Set<Integer>> prereqs) {
        if(visited.contains(c)) return false;
        if(!prereqs.containsKey(c)) return true;

        visited.add(c);
        for(int p : prereqs.get(c)) {
            if(!dfs(p, visited, prereqs)) return false;
        }

        visited.remove(visited.size() - 1);
        prereqs.remove(c);
        return true;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.canFinish(2, new int[][]{{1,0}}));
        System.out.println(s.canFinish(2, new int[][]{{1,0},{0,1}}));
        System.out.println(s.canFinish(2, new int[][]{{1,0},{0,1},{0,1}}));
    }
}
