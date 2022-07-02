package middle.dfs;

import java.util.HashSet;
import java.util.Set;

/**
 * No.694 不同岛屿的数量(Microsoft)
 */
public class No_694 {
    Set<String> set = new HashSet<>();
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int numDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i =0 ; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, i, j, sb);
                    set.add(sb.toString());
                }
            }
        }

        return set.size();
    }

    private void dfs(int[][] grid, int i, int j, int origin_i, int origin_j, StringBuilder sb) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            //直接返回，在主函数循环中添加sb到set去重
            return;
        }

        grid[i][j] = 0;
        int relative_i = origin_i - i;
        int relative_j = origin_j - j;
//        sb.append('|');
//        sb.append(relative_i +',' + relative_j);
        sb.append(relative_i).append(relative_j);
        for (int[] dir : dirs) {
            dfs(grid, i + dir[0], j + dir[1], origin_i, origin_j, sb);
        }
    }
}
