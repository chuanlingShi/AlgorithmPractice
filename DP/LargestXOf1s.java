package DP;

public class LargestXOf1s {
    public int largest(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) {
            return 0;
        }
        int m = matrix[0].length;
        if (m == 0){
            return 0;
        }

        int[][] leftUp = leftUp(matrix, n, m);
        int[][] rightDown = rightDown(matrix, n, m);
        return merge(leftUp, rightDown, n, m);
    }

    private int merge(int[][] leftUp, int[][] rightDown, int n , int m) {
        int result = 0;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j++) {
                leftUp[i][j] = Math.min(leftUp[i][j], rightDown[i][j]);
                result = Math.max(result, leftUp[i][j]);
            }
        }
        return result;
    }

    private int[][] leftUp(int[][] matrix, int n,int m) {
        int[][] left = new int[n][m];
        int[][] up = new int[n][m];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j++){
                if (matrix[i][j] == 1){
                    left[i][j] = getNumber(left, i - 1, j - 1, n, m) + 1;
                    up[i][j] = getNumber(up, i - 1, j + 1, n, m) + 1;
                }
            }
        }
        merge(left, up, n, m);
        return left;
    }

    private int[][] rightDown(int[][] matrix, int n,int m) {
        int[][] right = new int[n][m];
        int[][] down = new int[n][m];
        for (int i = n - 1; i >= 0; i --) {
            for (int j = m - 1; j >= 0; j--){
                if (matrix[i][j] == 1){
                    right[i][j] = getNumber(right, i + 1, j + 1, n, m) + 1;
                    down[i][j] = getNumber(down, i + 1, j - 1, n, m) + 1;
                }
            }
        }
        merge(right, down, n, m);
        return right;
    }

    private int getNumber(int[][] number, int x, int y, int n, int m) {
        if (x < 0 || x >= n || y <0 || y >= m) {
            return 0;
        }
        return number[x][y];
    }
}
