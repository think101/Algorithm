package main.com.think101.leetcode.Patterns.DFS.FindAllRecipes;

import java.util.*;

public class Solution {
    private Set<String> reSet;
    private Set<String> suSet;
    Map<String, List<String>> recipeToIngreds = new HashMap<>();

    private final Set<String> res = new HashSet<>();


    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        reSet = new HashSet<>(Arrays.asList(recipes));
        suSet = new HashSet<>(Arrays.asList(supplies));

        for(int i = 0; i < recipes.length; i++) {
            recipeToIngreds.put(recipes[i], ingredients.get(i));
        }

        for(String recipe: recipes) {
            if(dfs(recipe, new HashSet<>()))
                res.add(recipe);
        }

        return new ArrayList<>(res);
    }

    private boolean dfs(String recipe, Set<String> visited) {
        if(visited.contains(recipe)) return false;    // circle

        for(String ing : recipeToIngreds.get(recipe)) {
            if(!(suSet.contains(ing) || reSet.contains(ing))){
                return false;
            }

            if(reSet.contains(ing)) {
                visited.add(recipe);
                boolean create = dfs(ing, visited);
                visited.remove(visited.size() - 1);

                if(!create)
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        main.com.think101.leetcode.Patterns.DFS.FindAllRecipes.Solution s = new main.com.think101.leetcode.Patterns.DFS.FindAllRecipes.Solution();
        System.out.println(s.findAllRecipes(new String[]{"bread", "sandwich", "burger"}, new ArrayList<>() {{
            add(Arrays.asList("yeast", "flour"));
            add(Arrays.asList("bread", "meat"));
            add(Arrays.asList("sandwich", "meat", "bread"));
        }}, new String[]{"yeast", "flour", "meat"}));
    }
}