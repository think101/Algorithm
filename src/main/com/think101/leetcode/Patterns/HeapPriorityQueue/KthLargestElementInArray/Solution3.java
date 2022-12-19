package main.com.think101.leetcode.Patterns.HeapPriorityQueue.KthLargestElementInArray;

/*
 * This is the same as Solution2, I just want to play with it a bit
 */
public class Solution3 {
    private int[] minHeap;
    private int k;
    private int size;

    public Solution3(int k, int[] nums) {
        this.minHeap = new int[k];
        this.k = k;
        this.size = 0;

        for(int i = 0; i < k && i < nums.length; i++) {
            minHeap[size++] = nums[i];
            heapifyUp(minHeap, size - 1);
        }

        for(int i = k; i < nums.length; i++) {
            if(nums[i] > minHeap[0]) {
                minHeap[0] = nums[i];
                heapifyDown(minHeap, 0, size);
            }
        }
    }

    private void heapifyUp(int[] minHeap, int i) {
        while(i > 0) {
            int parent = (i - 1) / 2;
            if(minHeap[parent] < minHeap[i]) break;
            else {
                swap(minHeap, parent, i);
                i = parent;
            }
        }
    }

    private void heapifyDown(int[] minHeap, int i, int size) {
        while(i < size) {
            int left = i * 2 + 1, right = i * 2 + 2;
            int min = i;
            if(left < k && minHeap[left] < minHeap[min]) {
                min = left;
            }
            if(right < k && minHeap[right] < minHeap[min]) {
                min = right;
            }

            if(min == i) break;
            else {
                swap(minHeap, i, min);
                i = min;
            }
        }
    }

    private void swap(int[] minHeap, int i, int j) {
        int t = minHeap[i];
        minHeap[i] = minHeap[j];
        minHeap[j] = t;
    }

    public int add(int val) {
        if(size < k) {
            minHeap[size++] = val;
            heapifyUp(minHeap, size - 1);
        }
        else if(minHeap[0] < val) {
            minHeap[0] = val;
            heapifyDown(minHeap, 0, k);
        }

        return minHeap[0];
    }

    public static void main(String[] args) {
        int[] nums = {};
        Solution3 solution = new Solution3(1, nums);
        System.out.println(solution.add(-3));
        System.out.println(solution.add(-2));
        System.out.println(solution.add(-4));
        System.out.println(solution.add(0));
        System.out.println(solution.add(4));
    }
}
