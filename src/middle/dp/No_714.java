package middle.dp;

/**
 * @author Eurus.T
 * No.714 买卖股票的最佳时机含手续费
 */
public class No_714 {
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        int[] dp = new int[2];
        dp[1] = -prices[0]; //持有
        for (int i = 1; i < len; i ++) {
//            int temp = dp[0];
            dp[0] = Math.max(dp[0], dp[1] + prices[i] - fee);
            dp[1] = Math.max(dp[1], dp[0] - prices[i]);
        }

        return dp[0];
    }
}
