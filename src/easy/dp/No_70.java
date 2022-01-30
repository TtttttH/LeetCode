package easy.dp;

/**
 * No.70 爬楼梯
 */
public class No_70 {
    public int climbStairs(int n ) {
        if (n <= 2) {
            return n;
        }

        int[] dp = new int[3];
        dp[1] = 1;
        dp[2] = 2;
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = dp[1] + dp[2];
            dp[1] = dp[2];
            dp[2] = sum;
        }

        return sum;
    }
}
