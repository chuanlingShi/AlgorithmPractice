package DP;

//TC: O(n * m * m)  SC: O(n * m)
public class LargestSubMatrixSum {
    public int largest(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++){
            int[] cur = new int[m];
            for (int j = i; j < n; j ++) {
                add(cur, matrix[j]);
                result = Math.max(result, max(cur));
            }
        }
        return result;
    }

    private void add(int[] cur, int[] add) {
        for (int i = 0; i < cur.length; i ++) {
            cur[i] += add[i];
        }
    }

    private int max(int[] cur) {
        int result = cur[0];
        int tmp = cur[0];
        for (int i = 1; i < cur.length; i++) {
            tmp = Math.max(tmp + cur[i], cur[i]);
            result = Math.max(result, tmp);
        }
        return result;
    }
}
