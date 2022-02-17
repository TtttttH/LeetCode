package middle.dp;

/**
 * No.688 骑士在棋盘上的概率
 */
public class No_688 {
    public double knightProbability(int n, int k, int row, int column) {
        int[][] dirs = {{-2,-1}, {-2, 1}, {-1, -2}, {-1, 2}, {2, 1}, {2, -1}, {1, -2}, {1, 2}}; //记录方向
        double[][][] dp = new double[k + 1][n][n]; //三维动态数组
        for (int step = 0; step <= k; step++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    {
                        if (step == 0) {
                            dp[step][i][j] = 1;
                            continue;
                        }

                        for (int[] dir : dirs) {
                            int newRow = i + dir[0];
                            int newColumn = j + dir[1];
                            if (newRow >= 0 && newRow < n && newColumn >= 0 && newColumn < n) {
                                dp[step][i][j] += dp[step - 1][newRow][newColumn] / 8;
                            }
                        }
                    }
                }
            }
        }
        return dp[k][row][column];
    }
}
