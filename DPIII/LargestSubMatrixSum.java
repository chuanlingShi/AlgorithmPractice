package DPIII;

public class LargestSubMatrixSum {
    public int largest(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int globalMax = Integer.MIN_VALUE;
        //pre-processing
        int[][] prefixSum1D = new int[rows][cols]; //每一行 prefix sum
        int[][] prefixSum2D = new int[rows][cols]; // (0, 0) to (i, j) sum

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (j == 0 ) {
                    prefixSum1D[i][j] = matrix[i][j];
                } else {
                    prefixSum1D[i][j] = prefixSum1D[i][j - 1] + matrix[i][j];
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 ) {
                    prefixSum2D[i][j] = prefixSum1D[i][j];
                } else {
                    prefixSum2D[i][j] = prefixSum2D[i-1][j] + prefixSum1D[i][j];
                }
            }
        }
        //遍历左上角和右下角
        for (int k = 0; k < rows; k++) {
            for (int t = 0; t < cols; t++) {
                for (int i = k; i < rows; i++) {
                    for (int j = t; j < cols; j++) {
                        int top = k - 1 < 0 ? 0 : prefixSum2D[k-1][j];
                        int left = t - 1 < 0? 0 : prefixSum2D[i][t-1];
                        int dup = k - 1 < 0 || t - 1 < 0 ? 0 : prefixSum2D[k - 1][t - 1];
                        int cur = prefixSum2D[i][j] - top - left + dup;
                        globalMax = Math.max(globalMax, cur);
                    }
                }
            }
        }
        return globalMax;
    }
}
