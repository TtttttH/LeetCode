package middle.unionFindSet;

import java.util.ArrayList;
import java.util.List;

/**
 * No.305 岛屿数量II
 */
public class No_305 {

    //todo 并查集问题
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        int[][] grid = new int[m][n];
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int count = 0;
        for (int[] position : positions) {
            int r = position[0];
            int c = position[1];
            grid[r][c] = 1;
            if (checkIsolated(grid, r, c, dirs)) count ++;
            ans.add(count);
        }

        return ans;
    }

    private boolean checkIsolated(int[][] grid, int r, int c, int[][] dirs) {
        for (int[] dir : dirs) {
            int next_r = r + dir[0];
            int next_c = c + dir[1];
            if (next_r >= 0 && next_c >= 0 && next_r < grid.length && next_c < grid[0].length && grid[next_r][next_c] == 1) return false;
        }

        return true;
    }
}
