package middle.dp;

/**
 * No.122 买卖股票的最佳时机II
 */
public class No_122 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }

        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i ++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]); //第i天不持有
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]); //第i天持有
        }

        return dp[len - 1][0];
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 4, 5};
        No_122 test = new No_122();
        System.out.println(test.maxProfit(prices));
    }
}
