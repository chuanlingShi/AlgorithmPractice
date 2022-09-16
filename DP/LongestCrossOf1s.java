package DP;

/**
 * Given a matrix that contains only 1s and 0s, find the largest cross which contains only 1s, with the same arm lengths and the four arms joining at the central point.
 *
 * Return the arm length of the largest cross.
 *
 * Assumptions
 *
 * The given matrix is not null, has size of N * M, N >= 0 and M >= 0.
 * Examples
 *
 * { {0, 0, 0, 0},
 *
 *   {1, 1, 1, 1},
 *
 *   {0, 1, 1, 1},
 *
 *   {1, 0, 1, 1} }
 *
 * the largest cross of 1s has arm length 2.
 *
 *
 */
public class LongestCrossOf1s {
    public int largest(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) {
            return 0;
        }
        int m = matrix[0].length;
        if (m == 0) {
            return 0;
        }

        int[][] leftUp = leftUp(matrix, n, m);
        int[][] rightDown = rightDown(matrix, n, m);
        return merge(leftUp, rightDown, n, m);
    }

    private int merge(int[][] leftUp, int[][] rightDown, int n, int m) {
        int result = 0;
        for (int i =0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                leftUp[i][j] = Math.min(leftUp[i][j], rightDown[i][j]);
                result = Math.max(result, leftUp[i][j]);
            }
        }
        return result;
    }

    private int[][] leftUp(int[][] matrix, int n, int m) {
        int[][] left = new int[n][m];
        int[][] up = new int[n][m];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 && j == 0) {
                        up[i][j] = 1;
                        left[i][j] = 1;
                    }else if (i == 0) {
                        up[i][j] = 1;
                        left[i][j] = left[i][j -1] + 1;
                    }else if (j == 0) {
                        up[i][j] = up[i - 1][j] + 1;
                        left[i][j] = 1;
                    }else {
                        up[i][j] = up[i - 1][j] + 1;
                        left[i][j] = left[i][j - 1] + 1;
                    }
                }
            }
        }
        merge(left, up, n, m);
        return left;
    }

    private int[][] rightDown(int[][] matrix, int n, int m) {
        int[][] right = new int[n][m];
        int[][] down = new int[n][m];
        for (int i = n -1; i >= 0; i --) {
            for (int j = m - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    if (i == n -1 && j == m - 1) {
                        down[i][j] = 1;
                        right[i][j] = 1;
                    }else if (i == n - 1) {
                        down[i][j] = 1;
                        right[i][j] = right[i][j + 1] + 1;
                    }else if (j == m - 1) {
                        down[i][j] = down[i + 1][j] + 1;
                        right[i][j] = 1;
                    }else {
                        down[i][j] = down[i + 1][j] + 1;
                        right[i][j] = right[i][j + 1] + 1;
                    }
                }
            }
        }
        merge(right, down, n, m);
        return right;
    }
}
