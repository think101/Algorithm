package main.com.think101.leetcode.PopulatingNextRightPointersinEachNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public Node connect(Node root) {
        if(root == null)
            return null;

        List<List<Node>> levels = new ArrayList<>();

        List<Node> r = new ArrayList<>();
        r.add(root);
        levels.add(r);

        while(true) {
            List<Node> t = new ArrayList<>();
            for(Node n : levels.get(levels.size()-1)) {
                if(n.left != null)
                    t.add(n.left);
                if(n.right != null)
                    t.add(n.right);
            }

            if(t.isEmpty())
                break;

            levels.add(t);
        }

        for(List<Node> l : levels) {
            for(int i=0; i<l.size()-1; i++)
                l.get(i).next = l.get(i+1);
        }

        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
