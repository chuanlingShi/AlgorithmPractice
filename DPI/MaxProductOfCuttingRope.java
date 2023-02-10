package DPI;

public class MaxProductOfCuttingRope {
    //tc: O(n^2)
    //sc: O(n)
    public int maxProduct(int length) {
        if(length <= 1) {
            return 0;
        }
        int[] dp = new int[length + 1];
        for (int i = 2; i <= length; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * (i-j));
            }
        }
        return dp[length];
    }
}
