package middle.dp;

/**
 * No.516 最长回文子串 Longest Palindromic Subsequence
 */
public class No_516 {

    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
//            for (int j = i; j < len; j++) {
//                dp[i][j] = 1;
//            }
            dp[i][i] = 1; //这里初始化优化，只需要对dp[i][i]赋值
        }

        for (int i = len - 2; i >=0; i--) {
            for (int j = i + 1; j < len; j ++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][len - 1];
    }
}
