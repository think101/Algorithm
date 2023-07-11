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
    int originK;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if(k == 0) {
            nodes.add(target.val);
            return nodes;
        }

        if(root.val == target.val) {
            findChildrenInDistance(root.left, k - 1);
            findChildrenInDistance(root.right, k - 1);
            return nodes;
        }

        originK = k;
        findNode(root, target);
        findNodesInDistance(root, target, k);

        return nodes;
    }

    // return int[0] 0 means left branch, 1 means right branch
    private int[] findNode(TreeNode root, TreeNode target) {
        if(root == null) return new int[]{-1, 0};
        if(root.val == target.val) return new int[]{1, 0};

        int[] res;

        int[] l = findNode(root.left, target);

        if(l != null && l[0] != -1) {
            res = new int[]{0, l[1] + 1};
            preNodes.put(root.val, res);
            return res;
        }

        int[] r = findNode(root.right, target);
        if(r != null && r[0] != -1) {
            res = new int[]{1, r[1] + 1};
            preNodes.put(root.val, res);
            return res;
        }

        return null;
    }

    private void findNodesInDistance(TreeNode root, TreeNode target, int k) {
        if(root == null) return;

        if(k == 0) {
            if(root.val == target.val) {
                findChildrenInDistance(root.left, originK - 1);
                findChildrenInDistance(root.right, originK - 1);
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
            else if(r[1] == originK ) {
                nodes.add(root.val);
            }

            findNodesInDistance(root.left, target, r[1] - 1);
        }
        else {
            // right branch
            if(r[1] < k) {
                findNodesInDistance(root.left, target, k - r[1] - 1);
            }
            else if(r[1] == originK ) {
                nodes.add(root.val);
            }

            findNodesInDistance(root.right, target, r[1] - 1);
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
        TreeNode root = new TreeNode(0, null, new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, new TreeNode(4), null))));
        System.out.println(s.distanceK(root, new TreeNode(0), 2));
    }
}
