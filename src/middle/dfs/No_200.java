package middle.dfs;

/**
 * No.200 岛屿数量
 */
public class No_200 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    res ++;
                    dfs (grid, visited, m, n, i, j);
                }
            }
        }

        return res;
    }

    private void dfs(char[][] grid, boolean visited[][], int m, int n, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j] || grid[i][j] == '0') return;
        if (grid[i][j] == '1' && !visited[i][j]) visited[i][j] = true;
        dfs(grid, visited, m, n, i, j + 1);
        dfs(grid, visited, m, n, i, j - 1);
        dfs(grid, visited, m, n, i - 1, j);
        dfs(grid, visited, m, n, i + 1, j);
    }
}
