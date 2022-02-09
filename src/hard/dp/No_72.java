package hard.dp;

/**
 * No.72 Edit Distance
 */
public class No_72 {

    public int minDistance(String word1, String word2) {
        int len1 = word1.length() + 1;
        int len2 = word2.length() + 1;
        int[][] dp = new int[len1][len2];
        for (int i = 1; i < len1; i ++) {
            dp[i][0] = i;
        }

        for (int j = 1; j < len2; j ++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < len1; i ++) {
            for (int j = 1; j < len2; j ++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    //如果word1[i] = word2[j], 则由word1[0,i) 变为word2[0,j) 等于将word1[0,i-1) 变为word2[0, j-1)的步数
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //如果word1[i] != word2[j],分为如下三种情况:
                    //1.添加: word1[0,i) 变为word2[0, j - 1), 再加一个word2[j]
                    //2.删除: word1[0,i - 1) 变为word2[0, j), 再删除一个word1[i]
                    //3.替换: word1[0, i - 1) 变为word2[0, j - 1), 再将word1[i] 替换为 word2[j]
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1));
                }
            }
        }

        return dp[len1 - 1][len2 - 1];
    }
}
