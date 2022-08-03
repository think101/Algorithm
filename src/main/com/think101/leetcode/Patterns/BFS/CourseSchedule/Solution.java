package main.com.think101.leetcode.Patterns.BFS.CourseSchedule;

import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // course to its prerequistes
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        // reverse
        Map<Integer, Set<Integer>> rGraph = new HashMap<>();

        for(int[] p : prerequisites){
            if(!graph.containsKey(p[0]))
                graph.put(p[0], new HashSet<>());
            graph.get(p[0]).add(p[1]);

            if(!rGraph.containsKey(p[1]))
                rGraph.put(p[1], new HashSet<>());
            rGraph.get(p[1]).add(p[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++)
            if(!graph.containsKey(i))
                queue.add(i);

        while(queue.size() > 0) {
            int c = queue.poll();

            if(rGraph.containsKey(c)) {
                for(int requisite : rGraph.get(c)){
                    graph.get(requisite).remove(c);

                    if(graph.get(requisite).size() == 0){
                        queue.add(requisite);
                        graph.remove(requisite);
                    }
                }
            }
        }

        return graph.size() == 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.canFinish(2, new int[][]{{1,0}}));
        System.out.println(s.canFinish(2, new int[][]{{1,0},{0,1}}));
        System.out.println(s.canFinish(2, new int[][]{{1,0},{0,1},{0,1}}));
    }
}