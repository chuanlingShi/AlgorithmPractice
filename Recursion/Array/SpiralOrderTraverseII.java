package Recursion.Array;
/**
 * Traverse an M * N 2D array in spiral order clock-wise starting from the top left corner. Return the list of traversal sequence.
 *
 * Assumptions
 *
 * The 2D array is not null and has size of M * N where M, N >= 0
 * Examples
 *
 * { {1,  2,  3,  4},
 *
 *   {5,  6,  7,  8},
 *
 *   {9, 10, 11, 12} }
 *
 * the traversal sequence is [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
 */

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderTraverseII {
    public List<Integer> spiral(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        if (m == 0) {
            return list;
        }

        int n = matrix[0].length;
        int left = 0;
        int right = n - 1;
        int up = 0;
        int down = m - 1;
        while (left < right && up < down) {
            for (int i = left; i <= right; i ++){
                list.add(matrix[up][i]);
            }
            for (int i = up + 1; i <= down - 1; i ++){
                list.add(matrix[i][right]);
            }
            for (int i = right; i >= left; i --) {
                list.add(matrix[down][i]);
            }
            for (int i = down - 1; i >= up + 1; i--) {
                list.add(matrix[i][left]);
            }
            left ++;
            right --;
            up ++;
            down --;
        }
        if (left > right || up > down) {
            return list;
        }
        if (left == right) {
            for (int i = up; i <= down; i++) {
                list.add(matrix[i][left]);
            }
        }else {
            for (int i = left; i <= right; i ++){
                list.add(matrix[up][i]);
            }
        }
        return list;
    }
}
