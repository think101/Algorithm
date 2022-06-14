package main.com.think101.leetcode.contest.Test297.FairDistOfCookies;

class Solution {

    private int res = Integer.MAX_VALUE;

    public int distributeCookies(int[] cookies, int k) {
        int[] sums = new int[k];
        helper(cookies, 0, sums);
        return res;
    }

    private void helper(int[] cookies, int i, int[] sums) {
        if(i == cookies.length) {
            int t = Integer.MIN_VALUE;
            for (int sum : sums) {
                t = Math.max(t, sum);
            }

            res = Math.min(res, t);
            return;
        }

        for(int j = 0; j < sums.length; j++) {
            sums[j] += cookies[i];
            helper(cookies, i+1, sums);
            sums[j] -= cookies[i];
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] cookies = new int[]{8,15,10,20,8};
        System.out.println(s.distributeCookies(cookies, 2));

        s = new Solution();
        cookies = new int[]{1, 1, 1};
        System.out.println(s.distributeCookies(cookies, 3));

        s = new Solution();
        cookies = new int[]{1, 2, 3};
        System.out.println(s.distributeCookies(cookies, 3));

        s = new Solution();
        cookies = new int[]{6,1,3,2,2,4,1,2};
        System.out.println(s.distributeCookies(cookies, 3));

        s = new Solution();
        cookies = new int[]{8,15,10,20,8};
        System.out.println(s.distributeCookies(cookies, 2));
    }
}
