package main.com.think101.leetcode.Patterns.ArraysHashing.LargestNumber;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionTLE {
    private List<List<Integer>> res = new ArrayList<>();

    public String largestNumber(int[] nums) {
        String largest = "";

        List<List<Integer>> permutes = permute(nums);
        for(List<Integer> l : permutes) {
            String s = String.join("", l.stream().map(Object::toString).toArray(String[]::new));

            if(largest.compareTo(s) < 0) {
                largest = s;
            }
        }

        return largest;

    }

    private List<List<Integer>> permute(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            Set<Integer> s = new HashSet<>();
            s.add(i);
            List<Integer> l = new ArrayList<>();
            l.add(nums[i]);
            bt(nums, s, l);
        }

        return res;
    }

    private void bt(int[] nums, Set<Integer> visited, List<Integer> curr) {
        if(curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(!visited.contains(i)) {
                visited.add(i);
                curr.add(nums[i]);

                bt(nums, visited, curr);

                visited.remove(i);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        SolutionTLE s = new SolutionTLE();
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(s.largestNumber(nums));
    }
}

/*
 * Time complexity: O(n! * n * m) where n is the length of nums and m is the length of the largest number in nums
 *
 * The time complexity of the backtracking solution for generating all permutations of the given array is O(n!),
 * where n is the length of the input array.
 *
 * This is because there are n choices for the first element in the permutation, n-1 choices for the second element,
 * n-2 choices for the third element, and so on, until only one choice remains for the last element.
 * Therefore, the total number of permutations is n * (n-1) * (n-2) * ... * 1, which is n!.
 *
 * For each permutation, we need to concatenate the elements into a string using String.join and then compare it with
 * the current largest string using compareTo. The time complexity of concatenating the elements into a string is O(n),
 * where n is the length of the permutation. The compareTo method has a time complexity of O(m),
 * where m is the length of the strings being compared.
 *
 * Since we are generating all permutations and comparing them, the overall time complexity of the solution is O(n! * n * m).
 */
