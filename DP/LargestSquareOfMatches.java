package DP;

//TC: O(n * m * min(n,m))   SC:O(n * m)
public class LargestSquareOfMatches {
    public int largestSquareOfMatches(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int result = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] right = new int[m + 1][n + 1];
        int[][] down = new int[m + 1][n + 1];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (hasRight(matrix[i][j])) {
                    right[i][j] = right[i][j+1] + 1;
                }
                if (hasDown(matrix[i][j])) {
                    down[i][j] = down[i + 1][j] + 1;
                }
                if (hasBoth(matrix[i][j])) {
                    for (int maxLength = Math.min(right[i][j], down[i][j]); maxLength >= 1; maxLength --) {
                        if (right[i + maxLength][j] >= maxLength && down[i][j+ maxLength] >= maxLength) {
                            result = Math.max(result, maxLength);
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }
    private boolean hasRight(int val) {
        return (val & 0b1) != 0;
    }

    private boolean hasDown(int val) {
        return (val & 0b10) != 0;
    }

    private boolean hasBoth(int val) {
        return val == 0b11;
    }
}
