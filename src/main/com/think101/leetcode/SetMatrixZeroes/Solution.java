package main.com.think101.leetcode.SetMatrixZeroes;

public class Solution {

    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean colZero = false;
        boolean rowZero = false;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) rowZero = true;
                    if (j == 0) colZero = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int j = 1; j < col; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < row; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < row; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < col; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {
            if (colZero) {
                for (int i = 0; i < row; i++)
                    matrix[i][0] = 0;
            }
            if (rowZero) {
                for (int j = 0; j < col; j++)
                    matrix[0][j] = 0;
            }

        }
    }
}
