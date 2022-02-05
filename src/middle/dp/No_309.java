package middle.dp;

/**
 * No.309 最佳买卖股票时机含冷冻期
 */
public class No_309 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // 四种状态 0.持有(前一天及持有，当天买入:昨天冷冻期或者昨天是不持有 1. 不持有(不持有: 已经卖出或在冷冻期) 2.今天卖出 3.冷冻期
        int[] dp = new int[4];
        dp[0] = -prices[0];
        for (int i = 1; i < len; i ++) {
            int temp = dp[0];
            int temp2 = dp[2];
            dp[0] = Math.max(dp[0], Math.max(dp[3] - prices[i], dp[1] - prices[i]));
            dp[1] = Math.max(dp[1], dp[3]);
            dp[2] = temp + prices[i];
            dp[3] = temp2;
        }

        return dp[0];
// 两种状态二维数组模式
//        int[][] dp = new int[len][2]; //0.当天不持有 1.当天持有
//        dp[0][1] = -prices[0];
//        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
//        dp[1][1] = Math.max(dp[0][1], -prices[1]);
//        for (int i = 2; i < len; i ++) {
//            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
//            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
//        }
//
//        return dp[len - 1][0];
    }
}
