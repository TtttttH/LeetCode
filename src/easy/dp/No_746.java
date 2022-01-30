package easy.dp;

/**
 * No.746 Min Cost Climbing Stairs
 */
public class No_746 {

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[2]; //初始化为0
        int sum = 0;
        for (int i = 2; i <= cost.length; i ++) {
            sum = Math.min(dp[1] + cost[i - 1], dp[0] + cost[i - 2]);
            dp[0] = dp[1];
            dp[1] = sum;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        No_746 test = new No_746();
        int result = test.minCostClimbingStairs(cost);
        System.out.println(result);
    }
}
