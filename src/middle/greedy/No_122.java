package middle.greedy;

/**
 * No.122 买卖股票的最佳时机 II
 */
public class No_122 {
    public int maxProfit(int[] prices) {
        int income = 0;
        for (int i = 1; i < prices.length; i ++) {
            if (prices[i] > prices[i - 1]) {
                income += prices[i] - prices[i - 1];
            }
        }

        return income;
    }
}
