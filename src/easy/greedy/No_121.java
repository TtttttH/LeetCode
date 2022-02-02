package easy.greedy;

/**
 * No.121 买卖股票的最佳时机
 */
public class No_121 {
    public int maxProfit(int[] prices) {
        int max = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length ; i ++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        return max;
    }
}
