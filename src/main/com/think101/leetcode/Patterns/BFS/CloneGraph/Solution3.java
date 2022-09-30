package main.com.think101.leetcode.Patterns.BFS.CloneGraph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution3 {
    Set<Integer> visited = new HashSet<>();
    Map<Integer, Node> numToNode = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null) return null;

        return dfs(node);
    }

    private Node dfs(Node node) {
        if(visited.contains(node.val)) return numToNode.get(node.val);

        Node copy = new Node(node.val);
        numToNode.put(copy.val, copy);
        visited.add(copy.val);

        for(Node n : node.neighbors) {
            Node nCopy;
            if(numToNode.containsKey(n.val)) nCopy = numToNode.get(n.val);
            else nCopy = dfs(n);

            copy.neighbors.add(nCopy);
        }

        return copy;
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        Node res = s.cloneGraph(node1);
    }
}
