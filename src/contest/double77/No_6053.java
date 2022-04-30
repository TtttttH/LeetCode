package contest.double77;

public class No_6053 {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char[][] grids = new char[m][n];
        fillGrids(grids, guards, walls);
        fillGuided(grids, guards, m, n);
        int count = 0;
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (grids[i][j] == 0) count ++;
            }
        }
        return count;
    }

    void fillGrids(char[][] grids, int[][] guards, int[][] walls) {
        for (int[] guard : guards) {
            grids[guard[0]][guard[1]] = 'g';
        }

        for (int[] wall : walls) {
            grids[wall[0]][wall[1]] = 'w';
        }
    }

    void fillGuided(char[][] grids, int[][] guards, int m, int n) {
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int[] guard : guards) {
            for (int[] dir : dirs) {
                int i = guard[0] + dir[0];
                int j = guard[1] + dir[1];
                while (i < m && i >= 0 && j < n && j >= 0) {
                    if (grids[i][j] == 'g' || grids[i][j] == 'w') break;
                    grids[i][j] = 't';
                    i += dir[0];
                    j += dir[1];
                }
            }
        }
    }
}
