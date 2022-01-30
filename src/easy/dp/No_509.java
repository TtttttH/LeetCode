package easy.dp;

/**
 * No.509 斐波那契数
 */
public class No_509 {

    //递归效率比较低,迭代更快
    public int fib(int n) {
        if (n < 2) {
            return n;
        }

        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = 1;
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = sum;
        }

        return sum;
    }
}
