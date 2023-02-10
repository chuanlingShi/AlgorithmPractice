package DPI;

public class ArrayHopperI {
    public boolean canJump(int[] array) {
        if (array == null || array.length == 0) return false;
        boolean[] dp = new boolean[array.length];
        dp[array.length-1] = true;
        for (int i = array.length - 2; i >= 0; i--) {
            if (array[i] >= array.length - 1 - i) {
                dp[i] = true;
            } else {
               for (int j = i + array[i]; j >= 0; j--) {
                   if (dp[j]) {
                       dp[i] = true;
                       break;
                   }
               }
            }
        }
        return dp[0];
    }
}
