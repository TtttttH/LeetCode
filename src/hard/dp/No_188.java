package hard.dp;

/**
 * No.188 买卖股票的最佳实际IV
 * 思路: 类比于No.123的拓展，最大交易次数从两次变成多次,可以套用123的公式然后多一层循环，思路也是定义状态数，每次的买和卖各为一个状态方程
 */
public class No_188 {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        int[] dp = new int[2 * k + 1];
        for (int i = 1; i < 2*k; i = i + 2) {
            dp[i] = -prices[0];
        }

        for (int i = 1; i < len; i ++) {
            for (int j = 1; j < 2 * k; j = j + 2) {
                dp[j] = Math.max(dp[j], dp[j - 1] - prices[i]);
                dp[j + 1] = Math.max(dp[j + 1], dp[j] + prices[i]);
            }
        }

        return dp[2 * k];
    }
}
