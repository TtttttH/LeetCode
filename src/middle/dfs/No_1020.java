package middle.dfs;

/**
 * No.1020 飞地的数量
 */
public class No_1020 {
    public int numEnclaves(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[1].length; j ++) {
                if ((i == 0 || j == 0 || i == grid.length  - 1 || j == grid[0].length - 1) && grid[i][j] == 1) {
                    dfs(grid, i, j);
                }
            }
        }

        for (int[] ints : grid) {
            for (int j : ints) {
                if (j == 1) res++;
            }
        }

        return res;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0; //思路关键:将边框周围的1变成0!
        dfs(grid, i - 1, j); //上移
        dfs(grid, i, j - 1); //左移
        dfs(grid, i, j + 1); //右移
        dfs(grid, i + 1, j); //下移
    }
}
