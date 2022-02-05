package hard.dp;

/**
 * No.123 买卖股票的最佳时机III
 */
public class No_123 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }

        int[] dp = new int[5]; // 0.没有操作 1.第一次买入 2.第一次卖出 3.第二次买入 4.第二次卖出
        dp[1] = -prices[0];
        dp[3] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[1] = Math.max(dp[1], -prices[i]);
            dp[2] = Math.max(dp[2], dp[1] + prices[i]);
            dp[3] = Math.max(dp[3], dp[2] - prices[i]);
            dp[4] = Math.max(dp[4], dp[3] + prices[i]);
            System.out.println("dp:" + "," +dp[1] + "," + dp[2] + "," + dp[3] + "," + dp[4]);
        }

        return dp[4];

//        int[][] dp = new int[len][5]; // 0.没有操作  1.第一次买入  2.第一次卖出  3.第二次买入 4.第二次卖出
//        //初始化
//        dp[0][1] = -prices[0];
//        dp[0][3] = -prices[0];
//
//        for (int i = 1; i < len; i ++) {
//            dp[i][0] = dp[i - 1][0];
//            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
//            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
//            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
//            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
//            System.out.println("dp:"+dp[i][0] +"," +dp[i][1] + "," + dp[i][2] + "," + dp[i][3] + "," + dp[i][4]);
//        }
//
//        return dp[len - 1][4];
    }

    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
//        int[] prices = {7, 6, 5, 4, 3, 2, 1};
        No_123 test = new No_123();
        test.maxProfit(prices);
    }
}
