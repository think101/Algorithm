package main.com.think101.leetcode.Patterns.LinkedList.FindTheDuplicateNumber;

public class SolutionNotGood {
    public int findDuplicate(int[] nums) {
        int[] cnt = new int[nums.length];

        for (int num : nums) {
            if (cnt[num] == 1) return num;

            cnt[num]++;
        }

        return -1;
    }

    public static void main(String[] args) {
        SolutionNotGood s = new SolutionNotGood();
        int[] nums = new int[]{1,3,4,2,2};
        System.out.println(s.findDuplicate(nums));
    }
}
