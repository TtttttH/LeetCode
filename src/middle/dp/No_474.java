package middle.dp;

/**
 * No.474 Ones and Zeroes
 */
public class No_474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        int zeroNum;
        int oneNum;
        for (String str : strs) {
            zeroNum = 0;
            oneNum = 0;
            for (char ch : str.toCharArray()) {
                if (ch == 0) {
                    zeroNum++;
                } else {
                    oneNum++;
                }
            }

            for (int j = m; j >= zeroNum; j--) {
                for (int k = n; k >= oneNum; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zeroNum][k - oneNum]);
                }
            }
        }

        return dp[m][n];
    }
}
