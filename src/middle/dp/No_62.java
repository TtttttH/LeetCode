package middle.dp;

/**
 * No.62 Unique Paths
 */
public class No_62 {
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }

        int[][] dp = new int[m][n];

        //初始化
        for (int i = 0; i < m; i ++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i ++) {
            dp[0][i] = 1;
        }

        //开始递推
        for (int i = 1; i < m; i ++) {
            for (int j = 1; j < n; j ++) {
                //DP状态方程
                dp[i][j] = dp[i - 1][j] + dp[i][j-1];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int m = 3, n = 7;
        No_62 test = new No_62();
        System.out.println(test.uniquePaths(m, n));
    }
}
