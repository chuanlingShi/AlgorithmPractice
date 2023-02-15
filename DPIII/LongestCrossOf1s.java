package DPIII;

public class LongestCrossOf1s {
    public int largest(int[][] matrix) {
        //for each point, find max cross of it
        //check 4 directions
        //method 1: from mid to expand to 4 direct, find length -> O(n)
        //method 2: if we can pre-processing to save consecutive one for 4 direction, O(1) to check
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (rows == 0 || cols == 0) {
            return 0;
        }

        int[][] leftRight = buildLeftRight(matrix, rows,cols);
        int[][] rightLeft = buildRightLeft(matrix, rows, cols);
        int[][] upDown = buildUpDown(matrix, rows, cols);
        int[][] downUp = buildDownUp(matrix, rows, cols);
        //for each point check min of 4 directions
        //find max
        int globalMax = Integer.MIN_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                leftRight[i][j] = Math.min(leftRight[i][j], rightLeft[i][j]);
                upDown[i][j] = Math.min(upDown[i][j], downUp[i][j]);
                int curArm = Math.min(leftRight[i][j], upDown[i][j]);
                globalMax = Math.max(globalMax, curArm);
            }
        }
        return globalMax;
    }

    private int[][] buildLeftRight(int[][] matrix, int rows, int cols) {
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    if (j == 0) {
                        dp[i][j] = matrix[i][j];
                    }else {
                        dp[i][j] = dp[i][j-1] + 1;
                    }

                }
            }
        }
        return dp;
    }

    private int[][] buildUpDown(int[][] matrix, int rows, int cols) {
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0) {
                        dp[i][j] = matrix[i][j];
                    }else {
                        dp[i][j] = dp[i-1][j] + 1;
                    }

                }
            }
        }
        return dp;
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
