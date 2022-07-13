package SwordToOffer.middle;

public class Offer_13 {
    int count = 0;
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                dfs(visited, i, j, k);
            }
        }

        return count;
    }

    private void dfs(boolean[][] visited, int i, int j, int k) {
        if (i < 0 || i >= visited.length || j < 0 || j >= visited[0].length || visited[i][j]) return;
        if ((i / 10 + i % 10 + j % 10 + j / 10) > k) count ++;
        visited[i][j] = true;

        dfs(visited, i + 1, j, k);
        dfs(visited, i - 1, j, k);
        dfs(visited, i, j - 1, k);
        dfs(visited, i, j + 1, k);
    }
}
