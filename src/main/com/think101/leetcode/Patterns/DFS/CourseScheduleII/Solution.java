package main.com.think101.leetcode.Patterns.DFS.CourseScheduleII;

import java.util.*;

public class Solution {
    List<Integer> res = new ArrayList<>();
    Map<Integer, Set<Integer>> graph = new HashMap<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // create the graph
        for(int i = 0; i < numCourses; i++) {
            graph.put(i, new HashSet<>());
        }

        for(int[] prereq : prerequisites){
            graph.get(prereq[0]).add(prereq[1]);
        }

        for(int i = 0; i < numCourses; i++){
            if(!dfs(i, new HashSet<>()))
                return new int[0];
        }

        return res.stream().mapToInt(i -> i).toArray();
    }

    private boolean dfs(int course, Set<Integer> visited) {
        if(visited.contains(course)) return false; // circle exists
        else if(res.contains(course)) return true;

        visited.add(course);
        for(int p : graph.get(course)) {
            if(!dfs(p, visited)){
                return false;
            }
        }

        visited.remove(course);
        res.add(course);
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.findOrder(2, new int[][]{{1,0}})));
        System.out.println(Arrays.toString(s.findOrder(4, new int[][]{{1,0},{2,0}, {3,1}, {3,2}})));
    }
}