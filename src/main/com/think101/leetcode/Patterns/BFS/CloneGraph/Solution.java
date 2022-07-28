package main.com.think101.leetcode.Patterns.BFS.CloneGraph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null)
            return node;

        Queue<Node> origin = new LinkedList<>();
        Queue<Node> copy = new LinkedList<>();
        Map<Integer, Node> processed = new HashMap<>();

        origin.add(node);
        Node res = new Node(node.val);
        copy.add(res);
        processed.put(res.val, res);

        while(!origin.isEmpty()){
            Node o = origin.poll();
            Node c = copy.poll();
            for(Node n : o.neighbors) {
                if(processed.containsKey(n.val)) {
                    c.neighbors.add(processed.get(n.val));
                    continue;
                }


                Node copyNeighbor = new Node(n.val);
                c.neighbors.add(copyNeighbor);
                origin.add(n);
                copy.add(copyNeighbor);
                processed.put(n.val, copyNeighbor);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
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
        //System.out.println(res);
    }

}
