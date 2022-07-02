package middle.dfs;

/**
 * No.695 岛屿的最大面积(Microsoft)
 */
public class No_647 {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int res = 0;

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (grid[i][j] == 1) {
                    res = Math.max(dfs(grid, i, j), res);
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        int count = 1;
        grid[i][j] = 0;
        for (int[] dir : dirs) {
            count += dfs(grid, i + dir[0], j + dir[1]);
        }

        return count;
    }
}
