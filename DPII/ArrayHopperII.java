package DPII;

public class ArrayHopperII {
    public int minJump(int[] array) {
        //dp[i]: the min steps to jump out standing at i
        //base case: dp[length-1] = 0;
        //inductive rule: at index i,
        //case1: directly jump out,  dp[i] = 1
        //case2: find all stations (can jump out), look for min steps+1
        //tips: if no station, dp[i] = -1
        //return dp[0]
        if (array == null || array.length == 0 || array.length == 1) {
            return 0;
        }
        int[] dp = new int[array.length];
        dp[array.length - 1] = 0;
        for (int i = array.length - 2; i >= 0; i--) {
            if (array[i] + i >= array.length - 1) {
                dp[i] = 1;
            } else {
                int curMin = Integer.MAX_VALUE;
                for (int j = 1; j <= array[i]; j++) {
                    if (dp[i + j] > 0) {
                        curMin = Math.min(curMin, dp[i + j]);
                    }
                }
                //没有中转站
                if (curMin == Integer.MAX_VALUE) {
                    dp[i] = -1;
                }else {
                    dp[i] = curMin + 1;
                }
            }
        }
        return dp[0];
    }
}
