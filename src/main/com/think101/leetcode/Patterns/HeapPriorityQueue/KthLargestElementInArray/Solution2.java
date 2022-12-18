package main.com.think101.leetcode.Patterns.HeapPriorityQueue.KthLargestElementInArray;

/*
 *  This solution implements a min heap, which is a priority queue in Java.
 *  when adding a new element, if the size of the heap is less than k, we need to heapify up.
 *  if the size of the heap is equal to k, we need to remove the element at the heap top, and we need to heapify down the new value.
 */
public class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        int[] heap = new int[k];
        int size = 0;

        for(int n : nums) {
            if(size < k) {
                heap[size] = n;
                size++;
                heapifyUp(heap, size - 1);
            } else if(n > heap[0]) {
                heap[0] = n;
                heapifyDown(heap, 0, size);
            }
        }

        return heap[0];
    }

    private void heapifyUp(int[] heap, int i) {
        while(i > 0) {
            int parent = (i - 1) / 2;
            if(heap[parent] > heap[i]) {
                swap(heap, parent, i);
                i = parent;
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int[] heap, int i, int size) {
        while(i < size) {
            int left = i * 2 + 1;
            int right = i * 2 + 2;
            int min = i;

            if(left < size && heap[left] < heap[min]) min = left;
            if(right < size && heap[right] < heap[min]) min = right;

            if(min != i) {
                swap(heap, min, i);
                i = min;
            } else {
                break;
            }
        }
    }

    private void swap(int[] heap, int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }
}
