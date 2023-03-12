package main.com.think101.leetcode.Patterns.BFS.CloneGraph;

import java.util.*;

// 2023-03-11 Solution
public class Solution4 {
    Map<Integer, Node> valueToNode = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public Node cloneGraph(Node node) {
        bfs(node);
        return valueToNode.get(node.val);
    }

    private void bfs(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        visited.add(node.val);

        while(q.size() > 0) {
            node = q.poll();
            Node nodeCopy;
            if(valueToNode.containsKey(node.val)) {
                nodeCopy = valueToNode.get(node.val);
            }
            else {
                nodeCopy = new Node(node.val);
                valueToNode.put(node.val, nodeCopy);
            }

            for(Node n : node.neighbors) {
                if(valueToNode.containsKey(n.val)) {
                    nodeCopy.neighbors.add(valueToNode.get(n.val));
                }
                else {
                    Node nCopy = new Node(n.val);
                    nodeCopy.neighbors.add(nCopy);
                    valueToNode.put(n.val, nCopy);
                }

                if(!visited.contains(n.val)) {
                    q.add(n);
                    visited.add(n.val);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution4 s = new Solution4();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.neighbors.add(n2);
        n1.neighbors.add(n4);
        n2.neighbors.add(n1);
        n2.neighbors.add(n3);
        n3.neighbors.add(n2);
        n3.neighbors.add(n4);
        n4.neighbors.add(n1);
        n4.neighbors.add(n3);
        Node res = s.cloneGraph(n1);
        System.out.println(res);
    }
}
