package DPIII;

public class LargestSquareSurroundedByOne {
    public int largestSquareSurroundedByOne(int[][] matrix) {
        //solution: 站在每个点， 遍历以这个点为左上角的所有可能构成的正方形边长
        //对每个可能边长， 4个方向check这个边长能否真的构成一个正方形
        //for一个点， check右arm （上边） 下臂（左边）
        //（i, j + len - 1) check 下臂（右边）
        //(i + len - 1, j) check 右臂（下边）
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (rows == 0 || cols == 0 ) {
            return 0;
        }

        int globalResult = 0;
        int[][] rightLeft = buildRightLeft(matrix, rows, cols);
        int[][] downUp = buildDownUp(matrix, rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int maxPossibleLen = Math.min(rightLeft[i][j], downUp[i][j]);
                for (int k = maxPossibleLen; k > 0; k--) {
                    if (rightLeft[i + k - 1][j] >= k && downUp[i][j + k - 1] >= k) {
                        globalResult = Math.max(globalResult, k);
                        break;
                    }
                }
            }
        }
        return globalResult;

    }
    private int[][] buildRightLeft(int[][] matrix, int rows, int cols) {
        int[][] dp = new int[rows][cols];
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    if (j == cols -1) {
                        dp[i][j] = matrix[i][j];
                    }else {
                        dp[i][j] = dp[i][j+1] + 1;
                    }

                }
            }
        }
        return dp;
    }

    private int[][] buildDownUp(int[][] matrix, int rows, int cols) {
        int[][] dp = new int[rows][cols];
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    if (i == rows - 1) {
                        dp[i][j] = matrix[i][j];
                    }else {
                        dp[i][j] = dp[i+1][j] + 1;
                    }

                }
            }
        }
        return dp;
    }
}
