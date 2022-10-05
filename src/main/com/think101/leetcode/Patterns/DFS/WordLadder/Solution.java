package main.com.think101.leetcode.Patterns.DFS.WordLadder;

import java.util.*;

public class Solution {
    int res = Integer.MAX_VALUE;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        char[] alphabet = new char[]{'a','b','c','d','e','f','g','h','i','j','k',
                'l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        Map<String, Set<String>> graph = new HashMap<>();

        // find neighbors 1 char away
        for(String w : wordList) {
            if(!graph.containsKey(w)) {
                graph.put(w, new HashSet<>());
            }

            for(int i = 0; i < w.length(); i++) {
                for(char c : alphabet) {
                    if(c != w.charAt(i)) {
                        String t = w.substring(0, i) + c + w.substring(i+1);
                        if(wordList.contains(t)) {
                            graph.get(w).add(t);

                            if(!graph.containsKey(t))
                                graph.put(t, new HashSet<>());

                            graph.get(t).add(w);
                        }
                    }
                }
            }
        }


        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        boolean b = false;
        for(int i = 0; i < beginWord.length(); i++) {
            for(char c : alphabet) {
                if(c != beginWord.charAt(i)) {
                    String t = beginWord.substring(0, i) + c + beginWord.substring(i+1);
                    if(wordList.contains(t)) {
                        visited.add(t);
                        if(dfs(t, endWord, visited, graph))
                            b = true;
                        visited.remove(t);
                    }
                }
            }
        }

        if(b)
            return res;

        return 0;

    }

    private boolean dfs(String start, String end, Set<String> visited, Map<String, Set<String>> graph){
        if(visited.size() > res)
            return false;
        System.out.println(start + ":" + end);
        if(start.equals(end)) {
            res = Math.min(res, visited.size());
            //System.out.println("return: " + res);
            return true;
        }
        if(!graph.containsKey(start)) return false;

        boolean r = false;

        for(String neigh : graph.get(start)) {
            if(visited.contains(neigh)) continue;

            visited.add(neigh);
            if(dfs(neigh, end, visited, graph)) {
                r = true;
            }

            visited.remove(neigh);
        }

        return r;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));

        System.out.println(s.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log")));
        System.out.println(s.ladderLength("qa", "sq",
                Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le",
                        "av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya",
                        "cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo",
                        "as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha",
                        "hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la",
                        "st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni",
                        "mr","pa","he","lr","sq","ye")));

    }
}