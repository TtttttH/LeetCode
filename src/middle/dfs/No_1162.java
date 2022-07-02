package middle.dfs;

import java.util.Deque;
import java.util.LinkedList;

/**
 * No.1162 地图分析 (Microsoft)
 */
public class No_1162 {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int maxDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Deque<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (grid[i][j] == 1) queue.add(new int[] {i , j});
            }
        }

        if (queue.isEmpty() || queue.size() == m * n) return -1;

//        int res = Integer.MAX_VALUE;
        int[] p = null;
        while (!queue.isEmpty()) {
            p = queue.poll();
            for (int[] dir : dirs) {
                int x = p[0] + dir[0];
                int y = p[1] + dir[1];
                if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == 0) {
                    grid[x][y] = grid[p[0]][p[1]] + 1;
//                    res = Math.max(grid[x][y], res);
                    queue.offer(new int[] {x, y});
                }
            }
        }


        return grid[p[0]][p[1]] - 1;
    }
}
