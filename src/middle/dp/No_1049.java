package middle.dp;

/**
 * No.1049 Last Stone Weight II
 */
public class No_1049 {

    public int lastStoneWeightII(int[] stones) {
        if (stones.length == 1) {
            return stones[0];
        }
        
        int sum = 0;
        for (int weight : stones) {
            sum += weight;
        }

        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int weight : stones) {
            for (int j = target; j >= weight; j --) {
                dp[j] = Math.max(dp[j], dp[j - weight] + weight);
            }
        }

        return sum - 2 * dp[target];
    }
}
