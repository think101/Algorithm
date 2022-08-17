package main.com.think101.leetcode.Patterns.BFS.FindAllRecipes;

import java.util.*;

public class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> reSet = new HashSet<>(Arrays.asList(recipes));
        Set<String> suSet = new HashSet<>(Arrays.asList(supplies));
        Map<String, Set<String>> prereq = new HashMap<>();         // A -> [B, C], finish A need B, C ready
        Map<String, Set<String>> reversePrereq = new HashMap<>();  // C -> [A, D], C is dependent by A, D
        Queue<String> queue = new LinkedList<>();
        List<String> res = new ArrayList<>();

        for(int i = 0; i < recipes.length; i++) {
            String re = recipes[i];
            boolean canCreate = true;
            for(String in : ingredients.get(i)) {
                if(!(suSet.contains(in) || reSet.contains(in))){
                    canCreate = false;
                    break;
                }

                if(reSet.contains(in)) {
                    if(!prereq.containsKey(re))
                        prereq.put(re, new HashSet<>());
                    if(!reversePrereq.containsKey(in))
                        reversePrereq.put(in, new HashSet<>());

                    prereq.get(re).add(in);
                    reversePrereq.get(in).add(re);
                    canCreate = false;
                }
            }

            if(canCreate)
                queue.add(re);
        }

        while(queue.size() > 0) {
            String r = queue.poll();
            res.add(r);


            if(reversePrereq.containsKey(r)) {
                for(String t : reversePrereq.get(r)) {
                    prereq.get(t).remove(r);

                    if(prereq.get(t).size() == 0)
                        queue.add(t);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findAllRecipes(new String[]{"bread", "sandwich", "burger"}, new ArrayList<>() {{
            add(Arrays.asList("yeast", "flour"));
            add(Arrays.asList("bread", "meat"));
            add(Arrays.asList("sandwich", "meat", "bread"));
        }}, new String[]{"yeast", "flour", "meat"}));
    }
}
