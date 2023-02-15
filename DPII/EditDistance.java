package DPII;

public class EditDistance {
    public int editDistance(String one, String two) {
        //dp[i][j] = min steps to convert s1 (length is i) to s2 (length is j) by replace, insert, delete
        //dp[i][j] off by 1
        //base case:
        //dp[0][j]: 从empty string to any, dp[0][j] = j
        //dp[i][0]: from any to empty, dp[i][0] = i
        //induction rule:
        //case1: char(i-1) == char(j-1), dp[i][j] = dp[i-1][j-1]
        //case2: char(i-1) != char(j-1)
        //看待匹配的数
        //replace: dp[i][j] = dp[i-1][j-1] + 1 (replace last char)
        //delete: dp[i][j] = dp[i-1][j] + 1 (delete s1 last chat)
        //insert: dp[i][j] = dp[i][j-1] + 1 (insert into s1 last char)
        //return: dp[s1.len][s2.len]
        if (one == null || two == null) {
            return -1;
        }
        if (one.length() == 0) {
            return two.length();
        }
        if (two.length() == 0) {
            return one.length();
        }

        int[][] dp = new int[one.length() + 1][two.length() + 1];
        for (int i = 0; i <= one.length(); i++) {
            for (int j = 0; j <= two.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (one.charAt(i - 1) == two.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1] + 1, dp[i-1][j] + 1);
                    dp[i][j] = Math.min(dp[i][j], dp[i][j-1] + 1);
                }
            }
        }
        return dp[one.length()][two.length()];
    }
}
