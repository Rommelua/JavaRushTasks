package com.javarush.task.task39.task3912;

/* 
Максимальная площадь
*/

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {

    }

    public static int maxSquare(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1 && matrix[i][j - 1] > 0 && matrix[i - 1][j] > 0 && matrix[i - 1][j - 1] > 0) {
                    if (matrix[i][j - 1] == matrix[i - 1][j] && matrix[i - 1][j] == matrix[i - 1][j - 1]) {
                        matrix[i][j] = matrix[i - 1][j] + 1;
                    } else {
                        matrix[i][j] = Math.max(matrix[i][j - 1], Math.max(matrix[i - 1][j], matrix[i - 1][j - 1]));
                    }
                }
            }
        }
        int max = Arrays.stream(matrix).flatMapToInt(Arrays::stream).max().getAsInt();
        return max * max;
    }
}
