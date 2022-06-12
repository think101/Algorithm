package main.com.think101.leetcode.contest.Test297.CalculateAmountPaidInTaxes;

class Solution {
    public double calculateTax(int[][] brackets, int income) {

        int taxed = 0;
        double tax = 0;

        for (int[] bracket : brackets) {
            int taxable = Math.min(income - taxed, bracket[0] - taxed);

            if (taxable <= 0)
                break;

            taxed += taxable;
            tax += ((double) taxable * bracket[1]) / 100;
        }

        return tax;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] brackets = new int[][]{{3, 50}, {7, 10}, {12, 25}};
        System.out.println(s.calculateTax(brackets, 10));

        brackets = new int[][]{{1, 0}, {4, 25}, {5, 50}};
        System.out.println(s.calculateTax(brackets, 2));

        brackets = new int[][]{{2, 50}};
        System.out.println(s.calculateTax(brackets, 0));
    }
}
