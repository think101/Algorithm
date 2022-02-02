package main.com.think101.leetcode.RotateImage;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4}, {5,6, 7, 8}, {9,10,11,12}, {13,14,15,16}};

        System.out.println(Arrays.deepToString(matrix));
        rotate(matrix);

        System.out.println(Arrays.deepToString(matrix));
    }


    public static void rotate(int[][] matrix) {
        int a = 0, b = matrix.length-1;
        while(a <= b) {
            rotate(matrix, a++, b--);
        }
    }

    private static void rotate(int[][] matrix, int a, int b) {
        if(a == b)
            return;

        // move b-a steps
        for(int i=0; i<(b-a); i++) {
            int t = matrix[a][a];

            // move left column
            for(int k=0; k<(b-a); k++)
                matrix[a+k][a] = matrix[a+k+1][a];

            // move bottom row
            for(int k=0; k<(b-a); k++)
                matrix[b][a+k] = matrix[b][a+k+1];

            // move right column
            for(int k=0; k<(b-a); k++)
                matrix[b-k][b] = matrix[b-k-1][b];

            // move upper row
            for(int k=0; k<(b-a); k++)
                matrix[a][b-k] = matrix[a][b-k-1];

            matrix[a][a+1] = t;
        }
    }
}
