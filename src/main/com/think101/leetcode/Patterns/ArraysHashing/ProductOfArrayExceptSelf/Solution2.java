package main.com.think101.leetcode.Patterns.ArraysHashing.ProductOfArrayExceptSelf;

class Solution2 {
    public int[] productExceptSelf(int[] nums) {
        int[] m1 = new int[nums.length];
        int[] m2 = new int[nums.length];
        int[] res = new int[nums.length];

        m1[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            m1[i] = m1[i-1] * nums[i];
        }

        m2[nums.length - 1] = nums[nums.length - 1];
        for(int j = nums.length - 2; j >= 0; j--) {
            m2[j] = m2[j+1] * nums[j];
        }

        for(int k = 0; k < nums.length; k++) {
            int t = 1;
            if(k - 1 >= 0) t = t * m1[k-1];
            if(k + 1 <= nums.length - 1) t = t * m2[k+1];

            res[k] = t;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.productExceptSelf(new int[]{1,2,3,4}));
    }
}