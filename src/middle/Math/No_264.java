package middle.Math;

/**
 * No.264 丑数II(Microsoft)
 * 思路:设置三个指针，初始时都是从1开始，dp[1]=1是第一个丑数，后面的丑数都是由乘2，3，5得来的，乘完一次指针就需要向前移动一位到下一个丑数处等待被乘
 */
public class No_264 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2;
            int num3 = dp[p3] * 3;
            int num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) p2 ++;
            if (dp[i] == num3) p3 ++;
            if (dp[i] == num5) p5 ++;
        }

        return dp[n];
    }
}
