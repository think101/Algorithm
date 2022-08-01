package main.com.think101.leetcode.Patterns.DFS.CourseSchedule;

import java.util.*;

public class Solution {
    private final Map<Integer, List<Integer>> graph = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int[] p : prerequisites) {
            if(!graph.containsKey(p[0]))
                graph.put(p[0], new ArrayList<>());

            graph.get(p[0]).add(p[1]);
        }

        for(int i=0; i<numCourses; i++){
            if(!dfs(i, new HashSet<>()))
                return false;
        }

        return true;
    }

    private boolean dfs(int course, Set<Integer> visited) {
        if(visited.contains(course))
            return false;
        else if(!graph.containsKey(course))
            return true;

        visited.add(course);
        for(int c : graph.get(course)){
            if(!dfs(c, visited))
                return false;
        }

        visited.remove(course);
        graph.remove(course);
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.canFinish(2, new int[][]{{1,0}}));
        System.out.println(s.canFinish(2, new int[][]{{1,0},{0,1}}));
        System.out.println(s.canFinish(2, new int[][]{{1,0},{0,1},{0,1}}));
    }
}
