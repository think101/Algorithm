package main.com.think101.leetcode.SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] visited = new int[row][col];
        List<Integer> res = new ArrayList<>();

        int i=0, j=0;
        res.add(matrix[0][0]);
        visited[0][0] = 1;
        while(true) {
            // if upper row, go right
            if(j+1<col && (i-1<0 || visited[i-1][j] == 1) && visited[i][j+1] == 0) {
                visited[i][j+1] = 1;
                res.add(matrix[i][j+1]);
                j++;
                continue;
            }
            // if right column, go down
            else if(i+1<row && (j+1>=col || visited[i][j+1] == 1) && visited[i+1][j] == 0) {
                visited[i+1][j] = 1;
                res.add(matrix[i+1][j]);
                i++;
                continue;
            }
            // if bottom row, go left
            else if(j-1>=0 && (i+1>=row || visited[i+1][j] == 1) && visited[i][j-1] == 0) {
                visited[i][j-1] = 1;
                res.add(matrix[i][j-1]);
                j--;
                continue;
            }
            // if left column, go up
            else if(i-1>=0 && (j-1<0 || visited[i][j-1] == 1) && visited[i-1][j] == 0 ) {                               visited[i-1][j] = 1;
                res.add(matrix[i-1][j]);
                i--;
                continue;
            }

            break;
        }

        return res;
    }


    public List<Integer> spiralOrder2(int[][] matrix) {
        // 1 2 3 4 left down right up
        List<Integer> result = new ArrayList<>();

        int d = 1;
        int i = 0, j = 0;
        int row = matrix.length, col = matrix[0].length;

        while(true) {
            if(result.size() == row*col)
                break;

            if(d == 1) {
                while(j<col && matrix[i][j] != 111){
                    result.add(matrix[i][j]);
                    matrix[i][j] = 111;

                    j++;
                }
                i++;
                j--;
            }
            else if(d == 2) {
                while(i<row && matrix[i][j] != 111){
                    result.add(matrix[i][j]);
                    matrix[i][j] = 111;
                    i++;
                }
                i--;
                j--;
            }
            else if(d == 3) {
                while(j>=0 && matrix[i][j] != 111){
                    result.add(matrix[i][j]);
                    matrix[i][j] = 111;

                    j--;
                }
                i--;
                j++;
            }
            else {
                while(i>=0 && matrix[i][j] != 111){
                    result.add(matrix[i][j]);
                    matrix[i][j] = 111;

                    i--;
                }
                i++;
                j++;
            }

            d = d+1 > 4 ? 1 : d+1;
        }

        return result;
    }
}
