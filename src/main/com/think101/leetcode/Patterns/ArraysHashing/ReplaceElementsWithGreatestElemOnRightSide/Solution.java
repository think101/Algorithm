package main.com.think101.leetcode.Patterns.ArraysHashing.ReplaceElementsWithGreatestElemOnRightSide;

public class Solution {
    public int[] replaceElements(int[] arr) {
        int m = -1;
        for(int i = arr.length - 1; i >= 0; i--) {
            int t = arr[i];
            arr[i] = m;
            m = Math.max(m, t);
        }

        return arr;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{17,18,5,4,6,1};
        int[] res = s.replaceElements(arr);
        for(int i : res)
            System.out.print(i + " ");
    }
}
