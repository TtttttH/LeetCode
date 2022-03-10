package easy.dfs;

/**
 * No.463 岛屿的周长
 */
public class No_463 {
    public int islandPerimeter(int[][] grid) {
        int per = 0;
        if (grid == null || grid.length == 0) return per;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (grid[i][j] == 1) {
                    if (i + 1 >= m || grid[i + 1][j] == 0) per ++;
                    if (i - 1 < 0 || grid[i - 1][j] == 0) per ++;
                    if (j + 1 >= n || grid[i][j + 1] == 0) per ++;
                    if (j - 1 < 0 || grid[i][j - 1] == 0) per ++;
                }
            }
        }

        return per;
    }
}
