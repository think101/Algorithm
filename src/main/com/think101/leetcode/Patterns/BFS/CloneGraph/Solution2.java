package main.com.think101.leetcode.Patterns.BFS.CloneGraph;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public Node cloneGraph(Node node) {
        Map<Node, Node> origToCopy = new HashMap<>();

        return dfs(node, origToCopy);

    }

    private Node dfs(Node node, Map<Node, Node> origToCopy) {
        if(node == null)
            return node;

        Node copy = new Node(node.val);
        origToCopy.put(node, copy);
        for(Node n : node.neighbors) {
            if(origToCopy.containsKey(n)) {
                copy.neighbors.add(origToCopy.get(n));
                continue;
            }

            copy.neighbors.add(dfs(n, origToCopy));
        }

        return copy;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
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