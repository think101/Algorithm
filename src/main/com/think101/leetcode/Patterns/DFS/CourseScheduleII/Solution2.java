package main.com.think101.leetcode.Patterns.DFS.CourseScheduleII;

import java.util.*;

public class Solution2 {
    List<Integer> res = new ArrayList<>();
    Set<Integer> added = new HashSet<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> prereqs = new HashMap<>();
        for(int[] prereq : prerequisites) {
            if(!prereqs.containsKey(prereq[0]))
                prereqs.put(prereq[0], new HashSet<>());

            prereqs.get(prereq[0]).add(prereq[1]);
        }

        for(int i = 0; i < numCourses; i++){
            if(!dfs(i, new ArrayList<>(), prereqs))
                return new int[]{};
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean dfs(int c, List<Integer> visited, Map<Integer, Set<Integer>> prereqs) {
        if(visited.contains(c)) return false;
        if(!prereqs.containsKey(c)) {
            if(added.add(c))
                res.add(c);
            return true;
        }

        visited.add(c);
        for(int p : prereqs.get(c)) {
            if(!dfs(p, visited, prereqs))
                return false;
        }
        visited.remove(visited.size() - 1);

        prereqs.remove(c);
        if(added.add(c))
            res.add(c);
        return true;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(Arrays.toString(s.findOrder(2, new int[][]{{1,0}})));
        System.out.println(Arrays.toString(s.findOrder(2, new int[][]{{1,0},{0,1}})));
        System.out.println(Arrays.toString(s.findOrder(2, new int[][]{{1,0},{0,1},{0,1}})));
        System.out.println(Arrays.toString(s.findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}})));
    }
}
