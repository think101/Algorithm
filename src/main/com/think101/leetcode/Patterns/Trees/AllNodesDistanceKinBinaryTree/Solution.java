package main.com.think101.leetcode.Patterns.Trees.AllNodesDistanceKinBinaryTree;

import main.com.think101.leetcode.Patterns.Trees.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    //int[] a a[0] is 0 mean node on its left branch, 1 means on its right branch
    Map<Integer, int[]> preNodes = new HashMap<>();
    List<Integer> nodes = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findNode(root, target);
        findNodesInDistance(root, target, k);

        return nodes;
    }

    private int[] findNode(TreeNode root, TreeNode target) {
        if(root == null) return new int[]{-1, 0};
        if(root.val == target.val) return new int[]{1, 0};

        int[] res;

        int[] l = findNode(root.left, target);
        if(l[0] == 1) {
            res = new int[]{0, l[1] + 1};
            preNodes.put(root.val, res);
            return res;
        }

        int[] r = findNode(root.right, target);
        if(r[0] == 1) {
            res = new int[]{0, l[1] + 1};
            preNodes.put(root.val, res);
            return res;
        }

        return null;
    }

    private void findNodesInDistance(TreeNode root, TreeNode target, int k) {
        if(k == 0) {
            if(root.val == target.val) {
                findChildrenInDistance(root.left, k);
                findChildrenInDistance(root.right, k);
            }
            else {
                nodes.add(root.val);
            }

            return;
        }

        int[] r = preNodes.get(root.val);
        if(r == null) return;

        if(r[0] == 0) {
            // left branch
            if(r[1] < k) {
                findNodesInDistance(root.right, target, k - r[1] - 1);
            }
            else if(r[1] == k) {
                nodes.add(root.val);
            }
            else {
                findNodesInDistance(root.left, target, k - 1);
            }
        }
        else {
            // right branch
            if(r[1] < k) {
                findNodesInDistance(root.left, target, k - r[1] - 1);
            }
            else if(r[1] == k) {
                nodes.add(root.val);
            }
            else {
                findNodesInDistance(root.right, target, k - 1);
            }
        }
    }

    private void findChildrenInDistance(TreeNode root, int k) {
        if(k == 0 && root != null) {
            nodes.add(root.val);
            return;
        }

        if(root != null && k > 0) {
            findChildrenInDistance(root.left, k - 1);
            findChildrenInDistance(root.right, k - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))), new TreeNode(1, new TreeNode(0), new TreeNode(8)));
        System.out.println(s.distanceK(root, new TreeNode(5), 2));
    }
}
