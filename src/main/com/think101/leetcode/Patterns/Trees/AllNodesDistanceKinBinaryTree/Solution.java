package main.com.think101.leetcode.Patterns.Trees.AllNodesDistanceKinBinaryTree;

import main.com.think101.leetcode.Patterns.Trees.TreeNode;

import java.util.*;

class Solution {
    Map<Integer, Set<Integer>> neighbors = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findNeigh(root, null);

        Set<Integer> visited = new HashSet<>();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(target.val);

        for(int i = 0; i < k; i++) {
            int size = queue.size();
            for(int j = 0; j < size; j++) {
                int elem = queue.poll();

                visited.add(elem);
                for(int n : neighbors.get(elem)) {
                    if(!visited.contains(n)) queue.add(n);
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        res.addAll(queue);

        return res;
    }

    private void findNeigh(TreeNode node, TreeNode parent) {
        if(node == null) return;

        Set<Integer> ns = new HashSet<>();
        if(parent != null) ns.add(parent.val);
        if(node.left != null) ns.add(node.left.val);
        if(node.right != null) ns.add(node.right.val);

        neighbors.put(node.val, ns);

        findNeigh(node.left, node);
        findNeigh(node.right, node);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(0, null, new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, new TreeNode(4), null))));
        System.out.println(s.distanceK(root, new TreeNode(0), 2));
    }
}
